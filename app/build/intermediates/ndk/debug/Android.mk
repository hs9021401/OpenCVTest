LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := detection_based_tracker
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	E:\Project\Android\WorkSpace\OpenCVTest\app\src\main\jni\Android.mk \
	E:\Project\Android\WorkSpace\OpenCVTest\app\src\main\jni\Application.mk \
	E:\Project\Android\WorkSpace\OpenCVTest\app\src\main\jni\DetectionBasedTracker_jni.cpp \

LOCAL_C_INCLUDES += E:\Project\Android\WorkSpace\OpenCVTest\app\src\main\jni
LOCAL_C_INCLUDES += E:\Project\Android\WorkSpace\OpenCVTest\app\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
