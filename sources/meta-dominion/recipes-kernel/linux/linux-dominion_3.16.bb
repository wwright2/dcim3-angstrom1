require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(dominion|beast|macbook|soekris-net6501|arietta-g25)"

FILESPATH =. "${FILE_DIRNAME}/linux-dominion-3.16:${FILE_DIRNAME}/linux-dominion-3.16/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "3.16.3"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.16.y"
SRCREV_pn-${PN} = "c13c28207bf7d812d1b310a76013579cdb461b3e"

SRC_URI += " \
             file://defconfig \
             file://0001-btusb-add-USB-ID-for-ASUS-X79-DELUXE-onboard-BT.patch \
             file://0002-x86-quirks-soekris-HPET.patch \
             file://0003-block-cgroups-kconfig-build-bits-for-BFQ-v7r5-3.16.patch \
             file://0004-block-introduce-the-BFQ-v7r5-I-O-sched-for-3.16.patch \
             file://0005-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r5-for-.patch \
             file://0006-video-st7735fb-add-st7735-framebuffer-driver.patch \
             file://0007-CRDA-replace-placeholder-db.txt-with-the-real-one.patch \
             file://0008-Acme-boards-patches.patch \
             file://0009-ARM-DTS-arietta-G25-ttyS2-SPI0-ADC-on-expansion-head.patch \
             file://0010-ARM-DTS-acme-arietta-use-button-as-power-button.patch \
             file://0011-ARM-DTS-acme-arietta-drop-chosen-node.patch \
             file://0012-ARM-DTS-acme-arietta-add-128x32-OLED-on-i2c-0.patch \
             file://0013-ARM-DTS-acme-arietta-add-st7735fb-to-spi1.patch \
             file://0014-ARM-DT-increas-G25-SPI-to-24MHz.patch \
             file://0015-Btrfs-don-t-monopolize-a-core-when-evicting-inode.patch \
           "
