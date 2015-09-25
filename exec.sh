#!/bin/sh

cd "${0%/*}"
APATH=assignment${1}/ ./scripts/make_and_run.sh
