DESCRIPTION = "An image that will launch into the demo application for the embedded (not based on X11) version of Qt."
LICENSE = "MIT"
PR = "r3"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL += "\
	packagegroup-core-boot \
	packagegroup-core-basic \
	packagegroup-base-wifi \
	packagegroup-base-bluetooth \
	packagegroup-base-usbgadget \
	openssh-sftp \
	openssh-sftp-server \
	kernel-modules \
	lrzsz \
	setserial \
	opkg \
	iperf \
	\
	nbench-byte \
	lmbench \
	\
	linux-firmware-ralink \
	linux-firmware-ath6k \
	\
	i2c-tools \
	dosfstools \
	mtd-utils \
	iproute2 \
	iptables \
	bridge-utils \
	canutils \
	gdbserver \
	usbutils \
	wget \
	${CORE_IMAGE_BASE_INSTALL} \
	\
	qt4-embedded \
	libqt-embedded3support4 \
	libqt-embeddedclucene4 \
	libqt-embeddedcore4 \
	libqt-embeddeddbus4 \
	libqt-embeddedgui4 \
	libqt-embeddedhelp4 \
	libqt-embeddedmultimedia4 \
	libqt-embeddednetwork4 \
	libqt-embeddedscript4 \
	libqt-embeddedscripttools4 \
	libqt-embeddedsql4 \
	libqt-embeddedsvg4 \
	libqt-embeddedtest4 \
	libqt-embeddedwebkit4 \
	libqt-embeddedxml4 \
	libqt-embeddedxmlpatterns4 \
	qt4-embedded-fonts-ttf-dejavu \
	qt4-embedded-fonts-ttf-vera \
	qt4-embedded-plugin-iconengine-svgicon \
	qt4-embedded-plugin-imageformat-gif \
	qt4-embedded-plugin-imageformat-ico \
	qt4-embedded-plugin-imageformat-jpeg \
	qt4-embedded-plugin-imageformat-mng \
	qt4-embedded-plugin-imageformat-svg \
	qt4-embedded-plugin-imageformat-tiff \
	qt4-embedded-plugin-mousedriver-tslib \
	qt4-embedded-plugin-phonon-backend-gstreamer \
	qt4-embedded-plugin-script-dbus \
	qt4-embedded-plugin-sqldriver-sqlite \
	\
	libicui18n \
	tslib \
	tslib-calibrate \
	tslib-tests \
	gstreamer \
        gst-meta-base \
        gst-meta-video \
        gst-meta-audio \
	gst-plugins-good \
	gst-plugins-good-videofilter \
	gst-plugins-ugly-mpeg2dec \
	gst-plugins-bad-fbdevsink \
	homeautomation \
	smartrefrigerator \
	applicationlauncher \
	qmlbrowser \
	samegame \
	minehunt \
	atmel-qt-demo-init \
"

inherit core-image

# we don't need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/*Image*; "

atmel_qte_rootfs_postprocess() {
    curdir=$PWD
    # remove qtopia extra files
    rm -rf usr/bin/qtopia/demos
    rm -rf usr/bin/qtopia/examples
    rm -rf usr/share/doc
    rm -rf usr/share/qtopia/mkspecs
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "atmel_qte_rootfs_postprocess;"

sama5d3_xplained_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # autoload needed modules
    cd etc
    echo "atmel_usba_udc" >> modules
    echo "g_serial" >> modules

    cd $curdir
}
