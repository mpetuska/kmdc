#!/usr/bin/env bash

start="$(pwd)"
root="$(dirname "${BASH_SOURCE[0]}")/.."
root="$(cd "$root" && pwd)"

function updateVersionsCatalog() {
  "$root/gradlew" versionCatalogUpdate $@
}

targets=("build-conventions" "" "katalog" "sandbox")
for t in "${targets[@]}"; do
  target="$root/$t"
  echo ">>> Updating $target"
  cd "$target" && updateVersionsCatalog $@ || exit 1
done

cd "$start" && echo ">>> DONE!"
