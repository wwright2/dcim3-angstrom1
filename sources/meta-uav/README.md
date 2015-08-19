Meta-uav
================================

Introduction
-------------------------

The official OpenEmbedded/Yocto BSP layer for my UAV related software.

The meta-uav layer depends on:

	URI: git://git.openembedded.org/openembedded-core
	layers: meta
	branch: dora

	URI: git://git.openembedded.org/meta-openembedded
	layers: meta-oe
	branch: dora


	URI: git://github.com/meta-qt5
	layers: meta-qt5
	branch: dora

Optional:

	URI: git://github.com/bmwcarit/meta-ros
	layers: .
	branch: master

Please follow the recommended setup procedures of your OE distribution. For Angstrom that is http://www.angstrom-distribution.org/building-angstrom, other distros should have similar online resources.


Contributing
-------------------------

Please use github for pull requests: https://github.com/koenkooi/meta-uav/pulls

Reporting bugs
-------------------------

The github issue tracker (https://github.com/koenkooi/meta-uav/issues) is being used to keep track of bugs.

Maintainers: Koen Kooi <koen@dominion.thruhere.net>
