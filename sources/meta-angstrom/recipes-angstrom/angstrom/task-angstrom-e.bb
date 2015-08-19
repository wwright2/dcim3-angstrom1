DESCRIPTION = "Task packages for the Angstrom distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"


PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "\
    angstrom-e-base-depends \
    angstrom-e-depends"

ALLOW_EMPTY_angstrom-e-base-depends = "1"
ALLOW_EMPTY_angstrom-e-depends = "1"

RDEPENDS_angstrom-e-base-depends := "\
    angstrom-x11-base-depends \
    rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo \
    ttf-bitstream-vera \
    elementary-tests expedite e-wm \
    glibc-charmap-utf-8 glibc-localedata-i18n"
#xserver-kdrive-fbdev 

RDEPENDS_angstrom-e-depends := "\
                        pango-module-basic-fc \
                        gdk-pixbuf-loader-bmp \
                        gdk-pixbuf-loader-gif \
                        gdk-pixbuf-loader-jpeg \
                        gdk-pixbuf-loader-png \
                        gdk-pixbuf-loader-pnm \
                        gdk-pixbuf-loader-xbm \
                        gdk-pixbuf-loader-xpm"
