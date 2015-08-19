DESCRIPTION = "Linaro recipe for Aarch64 fast model kernels"

SRCREV_kernel="7123b02be92f8bfeffbf31f44252c24eb838a84d"
PV = "3.17+git${SRCPV}"

SRC_URI_append = " git://git.linaro.org/git/kernel/linux-linaro-tracking.git;protocol=http;name=kernel;nobranch=1 "
DEPENDS_append_aarch64 = " libgcc"
KERNEL_CC_append_aarch64 = " ${TOOLCHAIN_OPTIONS}"
KERNEL_LD_append_aarch64 = " ${TOOLCHAIN_OPTIONS}"


include linaro-kernel.inc
include bootwrapper.inc

COMPATIBLE_HOST = "aarch64"
KERNEL_IMAGETYPE = "Image"
BOOTARGS_COMMON = "console=ttyAMA0 mem=2048M devtmpfs.mount=1 earlyprintk=pl011,0x1c090000 consolelog=9 rw"

do_configure_prepend() {
    . ../ubuntu-ci/configs/vexpress64.cfg
    ARCH=arm64 scripts/kconfig/merge_config.sh -m $linaro_base_config_frags $ubuntu_config_frag $board_config_frags
}
