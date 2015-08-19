DESCRIPTION = "A basic image setup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RDEPENDS_${PN} += "\
    task-xserver \
    \
    strace \
    \
    dbus-x11 \
    xauth \
    xdg-utils \
    xhost \
    xinetd \
    xinit \
    xrandr \
    xrdb \
    xset \
    xvinfo \
    upower udisks \
    bash \
    tzdata \
    shared-mime-info \
"
