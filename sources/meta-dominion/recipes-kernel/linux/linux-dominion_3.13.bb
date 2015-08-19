require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(dominion|beast|macbook|soekris-net6501)"

FILESPATH =. "${FILE_DIRNAME}/linux-dominion-3.13:${FILE_DIRNAME}/linux-dominion-3.13/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "3.13.10"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.13.y"
SRCREV_pn-${PN} = "f994ec5a5d8094a195c23b08d373b055ef0044aa"

SRC_URI += " \
             file://0001-usb-stick-slowness-hack.patch \
             file://0002-btrfs-prepare-incompat-flags-for-more-compression-me.patch \
             file://0003-btrfs-select-LZ4-HC-libs.patch \
             file://0004-btrfs-lz4-add-wrapper-functions-and-enable-it.patch \
             file://0005-btrfs-add-lz4hc-incompat-bits.patch \
             file://0006-btrfs-add-lz4hc-wrapper-and-enable-it.patch \
             file://0007-btrfs-reduce-duplicate-code-in-lz4_wrapper.c.patch \
             file://0008-fb-udlfb-fix-scheduling-while-atomic.patch \
             file://0009-xhci-fix-usb3-streams.patch \
             file://0010-uas-properly-reinitialize-in-uas_eh_bus_reset_handle.patch \
             file://0011-uas-make-work-list-per-device.patch \
             file://0012-uas-add-dead-request-list.patch \
             file://0013-uas-replace-BUG_ON-WARN_ON-with-WARN_ON_ONCE.patch \
             file://0014-uas-remove-BROKEN.patch \
             file://0015-x86-quirks-soekris-HPET.patch \
             file://0016-block-cgroups-kconfig-build-bits-for-BFQ-v7r2-3.13.patch \
             file://0017-block-introduce-the-BFQ-v7r2-I-O-sched-for-3.13.patch \
             file://0018-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r2-for-.patch \
             file://defconfig \
"
