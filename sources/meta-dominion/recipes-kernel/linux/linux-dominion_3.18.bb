require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(dominion|beast|macbook|soekris-net6501|arietta-g25)"

FILESPATH =. "${FILE_DIRNAME}/linux-dominion-3.18:${FILE_DIRNAME}/linux-dominion-3.18/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "3.18.7"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.18.y"
SRCREV_pn-${PN} = "a17f9bf1f7cd3412b9920577a7c0ec34cb81b233"

SRC_URI += " \
             file://defconfig \
             file://0001-block-cgroups-kconfig-build-bits-for-BFQ-v7r6-3.18.patch \
             file://0002-block-introduce-the-BFQ-v7r6-I-O-sched-for-3.18.patch \
             file://0003-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r6-for-.patch \
             file://0004-btusb-add-USB-ID-for-ASUS-X79-DELUXE-onboard-BT.patch \
             file://0006-CRDA-replace-placeholder-db.txt-with-the-real-one.patch \
             file://0007-Acme-boards-patches.patch \
             file://0008-ARM-DTS-arietta-G25-ttyS2-SPI0-ADC-on-expansion-head.patch \
             file://0009-ARM-DTS-acme-arietta-use-button-as-power-button.patch \
             file://0010-ARM-DTS-acme-arietta-drop-chosen-node.patch \
           "
