LOCAL_PATH := $(call my-dir)
OPENCV_SDK_PATH := E:\Project\Android\AndroidLibrary\OpenCV
OPENCV_INC_PATH :=  $(OPENCV_SDK_PATH)\sdk\native\jni\include


include $(CLEAR_VARS)
#OPENCV_CAMERA_MODULES:=off
#OPENCV_INSTALL_MODULES:=off
#OPENCV_LIB_TYPE:=SHARED

include $(OPENCV_SDK_PATH)\sdk\native\jni\OpenCV.mk

LOCAL_SRC_FILES  := DetectionBasedTracker_jni.cpp

LOCAL_C_INCLUDES += $(LOCAL_PATH)
LOCAL_C_INCLUDES += OPENCV_INC_PATH\opencv
LOCAL_C_INCLUDES += OPENCV_INC_PATH\opencv2

LOCAL_LDLIBS     += -llog -ldl

LOCAL_MODULE     := detection_based_tracker

include $(BUILD_SHARED_LIBRARY)
