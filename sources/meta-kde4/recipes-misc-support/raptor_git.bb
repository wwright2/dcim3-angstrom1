LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS = "libxml2"
SRCREV = "b2c3b16b557c73807562a2b23f0b4020490b5d5e"
PV = "2.0.6+git${SRCPV}"
PR = "r1"

SRC_URI = "git://github.com/dajobe/raptor.git;branch=master \
           file://No-docs-and-NOCONFIGURE.patch \
           file://fix_EXTRA_DIST.patch \
          "

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "--enable-maintainer-mode"

# Redland autogen.sh does not work properly, so let OE do the job
do_configure() {
        cd ${S}
        touch gtk-doc.make
#       export NOCONFIGURE="no"; ./autogen.sh
        autoreconf -fi
        oe_runconf
}

BBCLASSEXTEND = "native"
