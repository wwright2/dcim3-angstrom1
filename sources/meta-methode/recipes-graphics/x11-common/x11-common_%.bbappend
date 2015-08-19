
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://x11.configs.tar.gz;name=x11configs"


do_install_append() {
    #

	cp -R usr ${D}/usr
    cp -R etc ${D}/etc
}

# see also i2c-tools_%.bbappend

