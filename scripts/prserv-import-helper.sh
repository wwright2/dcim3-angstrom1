#!/bin/sh

PRSERVFILE="$1"
if [ -e "${PRSERVFILE}" ] ; then
    echo "Using ${PRSERVFILE} to import PRs"
    cp ${PRSERVFILE} .
    . ./environment-angstrom-v2014.12
    time bitbake-prserv-tool import $(basename ${PRSERVFILE}) || true
fi
