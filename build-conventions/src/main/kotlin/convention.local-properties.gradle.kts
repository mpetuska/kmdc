import java.util.*

run {
  fun loadProps(file: File) {
    file.takeIf { it.exists() }
      ?.reader()
      ?.use { reader -> Properties().apply { load(reader) } }
      ?.forEach { k, v -> extra["$k"] = v }
  }
  loadProps(rootProject.file("local.properties"))
  loadProps(project.file("local.properties"))
}
