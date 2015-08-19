LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS = "db rasqal libtool libiodbc"
PR = "r2"

SRC_URI = "http://download.librdf.org/source/${BPN}-${PV}.tar.gz \
    file://No-docs-and-NOCONFIGURE.patch \
    "
SRC_URI[md5sum] = "b0deb87f3c7d3237a3d587c1e0f2f266"
SRC_URI[sha256sum] = "0e1f5825b6357c9b490da866c95ae1d895dbb5f445013d2511c37df822ee9ec6"

#see http://patches.openembedded.org/patch/33965/
SYSROOT_PREPROCESS_FUNCS += "redland_sysroot_preprocess"

inherit autotools gtk-doc

EXTRA_OECONF = "\
    --enable-maintainer-mode \
    --disable-gtk-doc \
    --with-raptor=system \
    --with-rasqal=system \
    --with-threestore=no \
    --with-mysql=no \
    --with-sqlite=no \
    --with-postgresql=no \
    --with-openssl-digests=no \
    --with-bdb=${STAGING_EXECPREFIXDIR} \
    --with-odbc-inc=${STAGING_INCDIR} \
    --with-odbc-lib=${STAGING_LIBDIR} \
    "

# Redland autogen.sh does not work properly, so let OE do the job
do_configure() {
    cd ${S}
    export NOCONFIGURE="no"; ./autogen.sh
    oe_runconf
}
do_install() {
    oe_runmake install DESTDIR=${D}
    install -d ${D}${bindir_crossscripts}
    install -m 755 ${D}${bindir}/redland-config ${D}${bindir_crossscripts}
}

RDEPENDS_${PN} = "rasqal raptor"

BBCLASSEXTEND = "native"

redland_sysroot_preprocess () {
       sysroot_stage_dir ${D}${bindir_crossscripts} ${SYSROOT_DESTDIR}${bindir_crossscripts}
}
