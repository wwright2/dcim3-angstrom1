require qt5-git.inc
require ${PN}.inc

# this wasn't released, the PV is set just to signify that this SRCREV was tested together
# with 5.3.2 version of other modules
PV = "5.3.2"
DEFAULT_PREFERENCE = "1"

QT_MODULE_BRANCH = "1.0"
QT_MODULE_BRANCH_CHROMIUM = "33.0.1750.170-based"

# For now we have to define SRC_URI here again as qt5-git.inc points to
# qt.gitorious.org/qt/ but qtwebengine is still on qt.gitorious.org/qt-labs/ which will
# switch soon.
SRC_URI = " \
    git://gitorious.org/qt/qtwebengine.git;name=qtwebengine;protocol=git;branch=${QT_MODULE_BRANCH} \
    git://gitorious.org/qt/qtwebengine-chromium.git;name=chromium;protocol=git;branch=${QT_MODULE_BRANCH_CHROMIUM};destsuffix=git/src/3rdparty \
    file://0001-Use-ninja-supplied-by-environment-variable-NINJA_PAT.patch \
    file://0002-functions.prf-Don-t-match-QMAKE_EXT_CPP-or-QMAKE_EXT.patch \
    file://0003-functions.prf-Try-to-add-_moc-suffix.patch \
    file://0001-chromium-Drop-build-time-only-dependency-on-x11-libr.patch \
    file://0002-chromium-Strip-unwanted-echo-compiling-prefix-from-C.patch \
    file://0003-chromium-base.gypi-include-atomicops_internals_x86_gcc.cc-whe.patch \
"
SRCREV_qtwebengine = "21f6ce84ecca9a4ff2aa980b21d2e5174c78d14b"
SRCREV_chromium = "1f3cc8c2618979b557d60ef1ad984a49dca83bff"

SRCREV_FORMAT = "qtwebengine"
