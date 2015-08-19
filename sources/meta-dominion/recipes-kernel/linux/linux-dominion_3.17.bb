require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(dominion|beast|macbook|soekris-net6501|arietta-g25)"

FILESPATH =. "${FILE_DIRNAME}/linux-dominion-3.17:${FILE_DIRNAME}/linux-dominion-3.17/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "3.17.6"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.17.y"
SRCREV_pn-${PN} = "30c80cbd7c775cb480248b08673cf5e9a57342fb"

SRC_URI += " \
             file://defconfig \
             file://0001-btusb-add-USB-ID-for-ASUS-X79-DELUXE-onboard-BT.patch \
             file://0002-x86-quirks-soekris-HPET.patch \
             file://0003-CRDA-replace-placeholder-db.txt-with-the-real-one.patch \
             file://0004-Acme-boards-patches.patch \
             file://0005-ARM-DTS-arietta-G25-ttyS2-SPI0-ADC-on-expansion-head.patch \
             file://0006-ARM-DTS-acme-arietta-use-button-as-power-button.patch \
             file://0007-ARM-DTS-acme-arietta-drop-chosen-node.patch \
             file://0008-ARM-DTS-acme-arietta-add-128x32-OLED-on-i2c-0.patch \
             file://0009-ARM-DTS-acme-arietta-add-st7735fb-to-spi1.patch \
             file://0010-ARM-DT-increas-G25-SPI-to-24MHz.patch \
             file://0011-block-cgroups-kconfig-build-bits-for-BFQ-v7r6-3.17.patch \
             file://0012-block-introduce-the-BFQ-v7r6-I-O-sched-for-3.17.patch \
             file://0013-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r6-for-.patch \
           "
