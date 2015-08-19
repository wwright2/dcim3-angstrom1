require u-boot-denx.inc

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

PV = "2014.01"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(beaglebone)"

# File is board-specific, only copy when it will be correct.
FWENV = ""

SRC_URI = "git://git.denx.de/u-boot.git \
           file://2013.10/0001-am335x-mux-don-t-hang-on-unknown-EEPROMs-assume-Beag.patch \
           file://2013.10/0003-beaglebone-HACK-raise-USB-current-limit.patch \
           file://2013.10/0004-beaglebone-use-kloadaddr-to-avoid-copying-the-kernel.patch \
           file://2013.10/0005-Fix-for-screen-rolling-during-video-playback.patch \
           file://2014.01/0002-beaglebone-HACK-always-return-1-for-is_bone_lt.patch \
           file://2014.01/0005-explicitly-clear-unaligned-access-bit.patch \
           file://2014.01/0009-ti_armv7_common.h-enable-CONFIG_API.patch \
           ${FWENV} \
          "

# v2014.01 release tag
SRCREV = "b44bd2c73c4cfb6e3b9e7f8cf987e8e39aa74a0b"

LIC_FILES_CHKSUM = "file://README;beginline=1;endline=22;md5=2687c5ebfd9cb284491c3204b726ea29"

S = "${WORKDIR}/git"

