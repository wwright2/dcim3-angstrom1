FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

EXTRA_OECONF += "	\
					--target=arm-linux-gnueabihf	\
"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

#TUNE_FEATURES     = "armv7a vfp thumb neon callconvention-hard cortexa8"
#                 --target=arm-angstrom-linux-gnueabi
#                 --target=arm-linux-gnueabi
#                 arm-linux-gnueabihf