SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.12:"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_ti33x = " am33x-cm3"
RDEPENDS_kernel-base_append_ti43x = " am33x-cm3"

# Add a run-time dependency for the VPE VPDMA firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_dra7xx = " vpe-vpdma-fw"

# Default is to package all dtb files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_ti33x = "am335x-evm.dtb am335x-evmsk.dtb am335x-bone.dtb am335x-boneblack.dtb"
KERNEL_DEVICETREE_ti43x = "am43x-epos-evm.dtb am437x-gp-evm.dtb"
KERNEL_DEVICETREE_beaglebone = "am335x-bone.dtb am335x-boneblack.dtb"
KERNEL_DEVICETREE_omap5-evm = "omap5-uevm.dtb"
KERNEL_DEVICETREE_dra7xx = "dra7-evm.dtb"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15"

S = "${WORKDIR}/git"

BRANCH = "ti-linux-3.12.y"

SRCREV = "68f449afccf6d1fb6b38bddfc3a40d9e97b53bdf"
PV = "3.12.30"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a+gitr${SRCPV}"
PR = "${MACHINE_KERNEL_PR}"

KERNEL_CONFIG_FRAGMENTS = "${WORKDIR}/baseport.cfg ${WORKDIR}/connectivity.cfg \
                           ${WORKDIR}/ipc.cfg"

SRC_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git;protocol=git;branch=${BRANCH} \
           file://defconfig \
           file://baseport.cfg \
           file://connectivity.cfg \
           file://ipc.cfg \
           file://systest.cfg \
          "

# Disable SMP in defconfig on single-core platforms to reduce overhead
SRC_URI_append_ti33x = "file://0001-Not-for-merge-ARM-config-omap-Disable-SMP-for-AM335x.patch"
SRC_URI_append_ti43x = "file://0001-Not-for-merge-ARM-config-omap-Disable-SMP-for-AM335x.patch"
