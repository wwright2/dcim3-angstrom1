#RPROVIDES_${PN} = "virtual/plasma-active-startscript"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=2;endline=17;md5=ab7ff4858efc6ddd5151e115b0bf2d9f"
DEPENDS = "kdelibs4 perl-native"
SRCREV = "98d63dd03e4976c621e1c1bb697cde24df96d729"
PV = "Active-Two+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/startactive.git;branch=master \
           file://setup-contour-intro.sh"

S = "${WORKDIR}/git"

inherit kde_cmake kde_rdepends

do_install_append() {
   install -d ${D}${bindir}
   install -m 0755 ${WORKDIR}/setup-contour-intro.sh ${D}${bindir}/
}

RDEPENDS_${PN} = "plasma-active kde-artwork-active contour"

FILES_${PN} += "\
                ${bindir}/startactive.bin \
                ${bindir}/setup-contour-intro.sh \
                ${datadir}/apps/startactive/* \
                ${datadir}/apps/startactive/modules/* \
                ${datadir}/apps/ksplash/Themes/qmldefault/* \
                ${datadir}/apps/ksplash/Themes/qmldefault/images/* \
               "
FILES_${PN}-dbg += "${bindir}/.debug/*"
