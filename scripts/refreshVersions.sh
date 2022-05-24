#!/usr/bin/env bash

start="$(pwd)"
root="$(dirname "${BASH_SOURCE[0]}")/.."
root="$(cd "$root" && pwd)"

function refreshVersions() {
  "$root/gradlew" refreshVersions
}

targets=("build-conventions" "" "katalog" "sandbox")
for t in "${targets[@]}"; do
  target="$root/$t"
  echo ">>> Refreshing $target"
  cd "$target" && refreshVersions
done

cd "$start" && echo ">>> DONE!"
