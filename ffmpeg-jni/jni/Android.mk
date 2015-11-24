ifeq ($(APP_ABI), x86)
include $(call my-dir)/Android.x86.mk
else
include $(call my-dir)/Android.arm.mk
endif

