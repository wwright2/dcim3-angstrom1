DESCRIPTION = "Qt-only wrapper for ModemManager DBus API."
LICENSE = "other"
LIC_FILES_CHKSUM = "file://${WORKDIR}/Licensing_Policy;md5=e8b46f5b1b4bd20c87d3f6d2ba120ffc"
DEPENDS = "networkmanager"
# latest / master HEAD
SRCREV = "498ae78a88acf79c1777a8ad0bfe37b63600c7cd"
PV = "+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/libmm-qt.git;branch=master \
    http://techbase.kde.org/Policies/Licensing_Policy"
# for license file
SRC_URI[md5sum] = "e8b46f5b1b4bd20c87d3f6d2ba120ffc"
SRC_URI[sha256sum] = "92d3083c97b3fde787556a28f0b3f3f1779d02fb30b429ffa37a56e1df6ab867"

S = "${WORKDIR}/git"

inherit kde_cmake

RDEPENDS_${PN} = "networkmanager"

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
