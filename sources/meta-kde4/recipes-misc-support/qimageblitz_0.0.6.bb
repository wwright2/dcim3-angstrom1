LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c262c13b60ebefe3060aed37d334ab6"
PR = "r1"

SRC_URI = "https://launchpad.net/ubuntu/+archive/primary/+files/qimageblitz_0.0.6.orig.tar.bz2 \
           file://fix-hardcode.patch \
          "
SRC_URI[md5sum] = "0ae2f7d4e0876764a97ca73799f61df4"
SRC_URI[sha256sum] = "9f102269dec50641440e23a449df215a0db9efef9a3969939d618c5e78a5010f"

inherit qt4x11 cmake

EXTRA_OECMAKE += "\
                  -DQT_LIBRARY_DIR=${OE_QMAKE_LIBDIR_QT} \
                  -DQT_INSTALL_LIBS=${OE_QMAKE_LIBDIR_QT} \
                  -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
                  -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
                  -DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
                  -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
                  -DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
                  -DQT_MKSPECS_DIR=${STAGING_DATADIR}/qt4/mkspecs \
                  -DQT_QT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/Qt \
                  -DQT_QTGUI_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/QtGui \
                  -DQT_QTCORE_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/QtCore \
                 "
