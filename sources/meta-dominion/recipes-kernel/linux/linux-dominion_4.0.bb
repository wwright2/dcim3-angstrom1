require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(dominion|beast|macbook|soekris-net6501|arietta-g25)"

FILESPATH =. "${FILE_DIRNAME}/linux-dominion-4.0:${FILE_DIRNAME}/linux-dominion-4.0/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "4.0.6"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.0.y"
SRCREV_pn-${PN} = "a0ce889438e8204b87d1f30f941646636e26837e"

SRC_URI += " \
             file://defconfig \
             file://0001-block-cgroups-kconfig-build-bits-for-BFQ-v7r7-3.19.patch \
             file://0002-block-introduce-the-BFQ-v7r7-I-O-sched-for-3.19.patch \
             file://0003-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r7-for-.patch \
             file://0004-wireless-populate-db.txt.patch \
             file://0005-btusb-add-USB-ID-for-ASUS-X79-DELUXE-onboard-BT.patch \
             file://0007-Acme-boards-patches.patch \
             file://0008-ARM-DTS-arietta-G25-ttyS2-SPI0-ADC-on-expansion-head.patch \
             file://0009-ARM-DTS-acme-arietta-use-button-as-power-button.patch \
             file://0010-ARM-DTS-acme-arietta-drop-chosen-node.patch \
           "
