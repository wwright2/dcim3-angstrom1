require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(dominion|beast|macbook|soekris-net6501)"

FILESPATH =. "${FILE_DIRNAME}/linux-dominion-3.14:${FILE_DIRNAME}/linux-dominion-3.14/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "3.14.2"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.14.y"
SRCREV_pn-${PN} = "798d3c532b82dce20bcdc512572f542093142d02"

SRC_URI += " \
             file://defconfig \
             file://0001-usb-core-let-dynamic-ids-override-static-ids.patch \
             file://0002-ohci-platform-Add-support-for-devicetree-instantiati.patch \
             file://0003-ehci-platform-Add-support-for-clks-and-phy-passed-th.patch \
             file://0004-ohci-platform-Add-support-for-controllers-with-big-e.patch \
             file://0005-ehci-platform-Add-support-for-controllers-with-big-e.patch \
             file://0006-usb-dwc2-handle-the-Host-Port-Interrupt-when-it-occu.patch \
             file://0007-usb-phy-msm-tiny-leak-on-error-in-probe.patch \
             file://0008-usb-move-hub-init-and-LED-blink-work-to-power-effici.patch \
             file://0009-ohci-platform-Change-compatible-string-from-usb-ohci.patch \
             file://0010-ehci-platform-Change-compatible-string-from-usb-ehci.patch \
             file://0011-USB-ehci-platform-check-for-platform-data-misconfigu.patch \
             file://0012-USB-ohci-platform-check-for-platform-data-misconfigu.patch \
             file://0013-Remove-MACH_OMAP_H4_OTG.patch \
             file://0014-USB-ELAN-Remove-useless-default-M-lines.patch \
             file://0015-usb-misc-usbled-Add-Riso-Kagaku-Webmail-Notifier.patch \
             file://0016-uhci-platform-Change-compatible-string-from-platform.patch \
             file://0017-xhci-platform-Change-compatible-string-from-xhci-pla.patch \
             file://0018-usb-dwc2-fix-dereference-before-NULL-check.patch \
             file://0019-usbhid-quirks-Ignore-Riso-Kagaku-Webmail-Notifier.patch \
             file://0020-usb-host-remove-USB_ARCH_HAS_-HCI.patch \
             file://0021-usb-host-remove-selects-of-USB_ARCH_HAS_-HCI.patch \
             file://0022-usb-chipidea-refine-PHY-operation.patch \
             file://0023-usb-chipidea-udc-refine-ep-operation-at-isr_tr_compl.patch \
             file://0024-usb-chipidea-use-dev_get_platdata.patch \
             file://0025-usb-chipidea-udc-add-maximum-speed-full-speed-option.patch \
             file://0026-usb-chipidea-Propagate-the-real-error-code-on-platfo.patch \
             file://0027-USB-complain-if-userspace-resets-an-active-endpoint.patch \
             file://0028-usb-wusbcore-fix-kernel-panic-on-HWA-unplug.patch \
             file://0029-usb-wusbcore-fix-stranded-URB-after-HWA-unplug.patch \
             file://0030-usb-wusbcore-prevent-urb-dequeue-and-giveback-race.patch \
             file://0031-usb-wusbcore-add-a-convenience-function-for-completi.patch \
             file://0032-usb-wusbcore-adjust-iterator-correctly-when-searchin.patch \
             file://0033-usb-wusbcore-read-actual_length-bytes-isoc-in-segmen.patch \
             file://0034-usb-wusbcore-add-info-to-HWA-debug-prints.patch \
             file://0035-hub-debug-message-for-failing-to-enable-device.patch \
             file://0036-usb-hub-usb_ext_cap_descriptor.bmAttributes-is-le32.patch \
             file://0037-usb-wusbcore-fix-compile-warnings.patch \
             file://0038-USB-EHCI-tegra-Drop-unused-defines.patch \
             file://0039-USB-sisusb-Use-static-const-fix-typo.patch \
             file://0040-usb-xhci-Change-how-we-indicate-a-host-supports-Link.patch \
             file://0041-xhci-make-warnings-greppable.patch \
             file://0042-xhci-fix-usb3-streams.patch \
             file://0043-xhci-Free-streams-when-they-are-still-allocated-on-a.patch \
             file://0044-xhci-Check-size-rather-then-number-of-streams-when-a.patch \
             file://0045-xhci-For-streams-the-css-flag-most-be-read-from-the-.patch \
             file://0046-xhci-Set-SCT-field-for-Set-TR-dequeue-on-streams.patch \
             file://0047-xhci-For-streams-the-dequeue-ptr-must-be-read-from-t.patch \
             file://0048-xhci-use-usb_ss_max_streams-in-xhci_check_streams_en.patch \
             file://0049-xhci-Remove-segments-from-radix-tree-on-failed-inser.patch \
             file://0050-usb-core-Fix-usb_free_streams-return-value-documenta.patch \
             file://0051-usb-core-Move-USB_MAXENDPOINTS-definitions-to-usb.h.patch \
             file://0052-usb-core-Track-if-an-endpoint-has-streams.patch \
             file://0053-usb-core-Free-bulk-streams-on-interface-release.patch \
             file://0054-usbfs-Kill-urbs-on-interface-before-doing-a-set_inte.patch \
             file://0055-usbfs-proc_do_submiturb-use-a-local-variable-for-num.patch \
             file://0056-usbfs-Add-support-for-bulk-stream-ids.patch \
             file://0057-usbfs-Add-ep_to_host_endpoint-helper-function.patch \
             file://0058-usbfs-Add-support-for-allocating-freeing-streams.patch \
             file://0059-uas-properly-reinitialize-in-uas_eh_bus_reset_handle.patch \
             file://0060-uas-make-work-list-per-device.patch \
             file://0061-uas-add-dead-request-list.patch \
             file://0062-uas-replace-BUG_ON-WARN_ON-with-WARN_ON_ONCE.patch \
             file://0063-uas-Urbs-must-be-anchored-before-submitting-them.patch \
             file://0064-uas-Properly-set-interface-to-altsetting-0-on-probe-.patch \
             file://0065-uas-Avoid-unnecessary-unlock-lock-calls-around-unlin.patch \
             file://0066-uas-uas_alloc_cmd_urb-drop-unused-stream_id-paramete.patch \
             file://0067-uas-Fix-uas-not-working-when-plugged-into-an-ehci-po.patch \
             file://0068-uas-Fix-reset-locking.patch \
             file://0069-uas-Fix-reset-handling-for-externally-triggered-rese.patch \
             file://0070-uas-s-response_ui-response_iu.patch \
             file://0071-uas-Fix-response-iu-struct-definition.patch \
             file://0072-uas-Pack-iu-struct-definitions.patch \
             file://0073-uas-Use-all-available-stream-ids.patch \
             file://0074-uas-Add-a-uas_find_uas_alt_setting-helper-function.patch \
             file://0075-uas-Move-uas-detect-code-to-uas-detect.h.patch \
             file://0076-xhci-xhci_mem_cleanup-make-sure-cmd_ring_reserved_tr.patch \
             file://0077-xhci-The-trb_address_map-radix-tree-expects-1KB-segm.patch \
             file://0078-xhci-Handle-MaxPSASize-0.patch \
             file://0079-usb-Clear-host_endpoint-streams-when-implicitly-free.patch \
             file://0080-usb-Reset-USB-3-devices-on-USB-3-link-bounce.patch \
             file://0081-uas-Add-the-posibilty-to-blacklist-uas-devices-from-.patch \
             file://0082-usb-storage-Don-t-bind-to-uas-devices-if-the-uas-dri.patch \
             file://0083-usb-storage-Modify-and-export-adjust_quirks-so-that-.patch \
             file://0084-uas-Honor-no-uas-quirk-set-in-usb-storage-s-quirks-m.patch \
             file://0085-uas-Add-uas_find_endpoints-helper-function.patch \
             file://0086-uas-Fix-bounds-check-in-uas_find_endpoints.patch \
             file://0087-uas-Move-uas_find_endpoints-to-uas-detect.h.patch \
             file://0088-uas-Drop-fixed-endpoint-config-handling.patch \
             file://0089-uas-Verify-endpoint-descriptors-from-uas_use_uas_dri.patch \
             file://0090-uas-Not-being-able-to-alloc-streams-when-connected-t.patch \
             file://0091-uas-task_mgmt-Kill-the-sense-urb-if-we-fail-to-submi.patch \
             file://0092-uas-Don-t-allow-more-then-one-task-to-run-at-the-sam.patch \
             file://0093-uas-Use-GFP_NOIO-rather-then-GFP_ATOMIC-where-possib.patch \
             file://0094-uas-Add-suspend-resume-support.patch \
             file://0095-uas-Reset-device-on-reboot.patch \
             file://0096-uas-Fix-task-management-not-working-when-connected-o.patch \
             file://0097-uas-uas_alloc_data_urb-Remove-unnecessary-use_stream.patch \
             file://0098-uas-Properly-complete-inflight-commands-on-bus-reset.patch \
             file://0099-uas-add-uas_mark_cmd_dead-helper-function.patch \
             file://0100-uas-cmdinfo-use-only-one-list-head.patch \
             file://0101-uas-Fix-command-task-mgmt-submission-racing-with-dis.patch \
             file://0102-uas-Fix-memory-management.patch \
             file://0103-uas-Clear-cmdinfo-on-command-queue-ing.patch \
             file://0104-uas-Use-the-right-error-codes-for-different-kinds-of.patch \
             file://0105-uas-Improve-error-reporting.patch \
             file://0106-uas-Add-some-data-in-out-ready-iu-sanity-checks.patch \
             file://0107-uas-Make-sure-sg-elements-are-properly-aligned.patch \
             file://0108-uas-remove-BROKEN.patch \
             file://0109-uas-Add-Hans-de-Goede-as-uas-maintainer.patch \
             file://0110-uas-Remove-comment-about-registering-a-uas-scsi-cont.patch \
             file://0111-xhci-Refactor-command-watchdog-and-fix-split-string.patch \
             file://0112-xhci-Kill-streams-URBs-when-the-host-dies.patch \
             file://0113-storage-accept-some-UAS-devices-if-streams-are-unava.patch \
             file://0114-xhci-Prevent-runtime-pm-from-autosuspending-during-i.patch \
             file://0115-xhci-add-the-meaningful-IRQ-description-if-it-is-emp.patch \
             file://0116-fb-udlfb-fix-scheduling-while-atomic.patch \
             file://0117-btrfs-prepare-incompat-flags-for-more-compression-me.patch \
             file://0118-btrfs-lz4-add-wrapper-functions-and-enable-it.patch \
             file://0119-btrfs-add-lz4hc-incompat-bits.patch \
             file://0120-btrfs-add-lz4hc-wrapper-and-enable-it.patch \
             file://0121-btrfs-reduce-duplicate-code-in-lz4_wrapper.c.patch \
             file://0122-btrfs-select-LZ4-HC-libs.patch \
             file://0123-x86-quirks-soekris-HPET.patch \
             file://0124-block-cgroups-kconfig-build-bits-for-BFQ-v7r2-3.13.patch \
             file://0125-block-introduce-the-BFQ-v7r2-I-O-sched-for-3.13.patch \
             file://0126-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r2-for-.patch \
             file://0127-block-bfq-Switch-from-BFQ-v7r2-for-3.13.0-to-BFQ-v7r.patch \
            "
