LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = "kdelibs4 taglib"
SRCREV = "b5bdfd96796192194fdcaafd1ac8e6043a6b0a25"
PV = "2.1.3+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/bangarang.git;protocol=git"

S = "${WORKDIR}/git"

inherit kde_cmake

FILES_${PN} += "${datadir}/*"
