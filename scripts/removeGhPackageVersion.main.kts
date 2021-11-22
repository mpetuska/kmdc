#!/usr/bin/env kotlin

// usage: ./removeGhPackageVersion.main.kts template-kmp-library 1.1.3

@file:DependsOn("io.ktor:ktor-client-cio-jvm:1.6.3")
@file:DependsOn("io.ktor:ktor-client-gson:1.6.3")
@file:DependsOn("io.ktor:ktor-client-auth-jvm:1.6.3")

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.providers.BasicAuthCredentials
import io.ktor.client.features.auth.providers.basic
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.host
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import kotlinx.coroutines.runBlocking

val targetRepo = args.getOrNull(0) ?: error("Target repository not specified")
val targetVersion = args.getOrNull(1) ?: error("Target version not specified")
println("TargetRepo[$targetRepo] TargetVersion[$targetVersion]")

val ghClient = HttpClient(CIO) {
  install(Auth) {
    basic {
      credentials {
        BasicAuthCredentials(
          username = System.getenv("GITHUB_LOGIN"),
          password = System.getenv("GITHUB_OAUTH")
        )
      }
      sendWithoutRequest { true }
    }
  }
  install(JsonFeature) {
    serializer = GsonSerializer()
  }
  defaultRequest {
    followRedirects = true
    host = "api.github.com"
    url {
      protocol = URLProtocol.HTTPS
    }
    header("Accept", "application/vnd.github.v3+json")
  }
}

data class GHRepository(val id: String, val node_id: String, val name: String, val full_name: String)
data class GHPackage(val id: String, val name: String, val package_type: String, val repository: GHRepository)
data class GHPackageVersion(val id: String, val name: String)

runBlocking {
  val packages = mutableListOf<GHPackage>().run {
    var i = 0
    while (true) {
      val page = ghClient.get<List<GHPackage>>("/user/packages") {
        parameter("package_type", "maven")
        parameter("page", "${++i}")
      }
      if (page.isEmpty()) {
        break
      } else {
        addAll(page.filter { it.repository.name == targetRepo })
      }
    }
    toList()
  }
  val versions = packages.map {
    it to mutableListOf<GHPackageVersion>().run {
      var i = 0
      while (true) {
        val page = ghClient.get<List<GHPackageVersion>>("/user/packages/${it.package_type}/${it.name}/versions") {
          parameter("package_type", "maven")
          parameter("page", "${++i}")
        }
        if (page.isEmpty()) {
          break
        } else {
          addAll(page)
        }
      }
      toList()
    }

  }
  versions.forEach { (pkg, ver) ->
    if (ver.size > 1) {
      ver.firstOrNull { it.name == targetVersion }?.let {
        println("Deleting ${pkg.name}@${it.name}")
        ghClient.delete<Unit>("/user/packages/${pkg.package_type}/${pkg.name}/versions/${it.id}")
      }
    } else if (ver.any { it.name == targetVersion }) {
      println("Deleting ${pkg.name}")
      ghClient.delete<Unit>("/user/packages/${pkg.package_type}/${pkg.name}")
    }
  }
}
