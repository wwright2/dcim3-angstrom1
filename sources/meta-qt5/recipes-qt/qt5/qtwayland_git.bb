require qt5-git.inc
require ${PN}.inc

SRCREV = "5f718c7d04d44c3878018e8070b18cf0e7486eb0"

SRC_URI += " \
    file://0001-examples.pro-include-server-buffer-only-when-buildin.patch \
"

QT_VERSION ?= "5.4.0"

do_install_append() {
    # do install files created by qtwaylandscanner
    install ${B}/include/QtCompositor/${QT_VERSION}/QtCompositor/private/qwayland-server-*.h ${D}${OE_QMAKE_PATH_QT_HEADERS}/QtCompositor/${QT_VERSION}/QtCompositor/private
    install ${B}/include/QtCompositor/${QT_VERSION}/QtCompositor/private/*protocol*.h ${D}${OE_QMAKE_PATH_QT_HEADERS}/QtCompositor/${QT_VERSION}/QtCompositor/private
}
