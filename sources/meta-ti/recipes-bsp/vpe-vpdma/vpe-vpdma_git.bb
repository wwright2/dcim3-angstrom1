DESCRIPTION = "VPE VPDMA firmware and test program"

DEPENDS += "virtual/kernel"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=74d2f71d8898c54e3d1c9d0058c484aa"

COMPATIBLE_MACHINE = "dra7xx"

PV = "1b8"
PR = "r2"

SRCREV = "e3d8db1aa935775f9d196ad7428e0cd9864a36ca"
BRANCH ?= "master"

SRC_URI = "git://git.ti.com/vpe_tests/vpe_tests.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

FLOATABI = "${@base_contains("TUNE_FEATURES", "vfp", base_contains("TUNE_FEATURES", "callconvention-hard", " -mfloat-abi=hard", " -mfloat-abi=softfp", d), "" ,d)}"

# The test application needs additional include headers from the kernel
EXTRA_OEMAKE = 'CROSS_COMPILE="${TARGET_PREFIX}" CC="${TARGET_PREFIX}gcc ${FLOATABI}" KDIR="${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include"'

do_install() {
    oe_runmake DESTDIR="${D}" install
}

# Separate the firmware into it's own package.
PACKAGES =+ "${PN}-fw"
FILES_${PN}-fw += "${base_libdir}/firmware"
