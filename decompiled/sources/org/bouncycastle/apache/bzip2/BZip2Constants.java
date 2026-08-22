package org.bouncycastle.apache.bzip2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.window.core.layout.WindowSizeClass;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.identity.intents.AddressConstants;
import com.google.android.vending.licensing.Policy;
import com.google.zxing.pdf417.PDF417Common;
import cz.msebera.android.httpclient.HttpStatus;
import easypay.appinvoke.manager.Constants;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: loaded from: classes10.dex */
public interface BZip2Constants {
    public static final int G_SIZE = 50;
    public static final int MAX_ALPHA_SIZE = 258;
    public static final int MAX_CODE_LEN = 23;
    public static final int MAX_SELECTORS = 18002;
    public static final int NUM_OVERSHOOT_BYTES = 20;
    public static final int N_GROUPS = 6;
    public static final int N_ITERS = 4;
    public static final int RUNA = 0;
    public static final int RUNB = 1;
    public static final int baseBlockSize = 100000;
    public static final int[] rNums = {619, 720, 127, 481, 931, 816, 813, 233, 566, 247, 985, 724, HttpStatus.SC_RESET_CONTENT, 454, 863, 491, 741, 242, 949, 214, 733, 859, 335, 708, 621, 574, 73, 654, 730, 472, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 436, 278, 496, 867, 210, 399, 680, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, 51, 878, 465, 811, ByteCode.RET, 869, 675, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, 697, 867, Policy.NOT_LICENSED, 862, 687, 507, 283, 482, 129, 807, 591, 733, 623, 150, 238, 59, 379, 684, 877, 625, ByteCode.RET, 643, 105, 170, TypedValues.MotionType.TYPE_PATHMOTION_ARC, 520, 932, 727, 476, 693, TypedValues.CycleType.TYPE_WAVE_PHASE, ByteCode.FRETURN, 647, 73, 122, 335, 530, 442, 853, 695, 249, 445, 515, 909, 545, 703, 919, 874, 474, 882, 500, 594, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 641, 801, 220, 162, 819, 984, 589, InputDeviceCompat.SOURCE_DPAD, 495, 799, 161, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, 958, 533, Constants.EASY_PAY_MINIMIZE_ASSIST, HttpStatus.SC_BAD_REQUEST, 386, 867, 600, 782, 382, 596, HttpStatus.SC_REQUEST_URI_TOO_LONG, ByteCode.LOOKUPSWITCH, 516, 375, 682, 485, 911, 276, 98, 553, 163, 354, 666, 933, 424, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 533, 870, 227, 730, 475, ByteCode.INVOKEDYNAMIC, 263, 647, 537, 686, 600, 224, 469, 68, 770, 919, 190, 373, 294, 822, 808, 206, ByteCode.INVOKESTATIC, 943, 795, RendererCapabilities.DECODER_SUPPORT_MASK, 383, 461, 404, 758, 839, 887, 715, 67, 618, 276, 204, 918, 873, 777, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, 560, 951, 160, 578, 722, 79, 804, 96, 409, 713, 940, 652, 934, 970, 447, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 353, 859, 672, 112, 785, 645, 863, 803, 350, 139, 93, 354, 99, 820, 908, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 772, 154, 274, 580, ByteCode.INVOKESTATIC, 79, 626, 630, 742, 653, 282, 762, 623, 680, 81, 927, 626, 789, 125, 411, 521, 938, 300, 821, 78, 343, ByteCode.DRETURN, 128, 250, 170, 774, 972, 275, 999, 639, 495, 78, 352, 126, 857, 956, 358, 619, 580, 124, 737, 594, TypedValues.TransitionType.TYPE_FROM, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 669, 112, 134, 694, 363, 992, 809, 743, 168, 974, 944, 375, 748, 52, 600, 747, 642, ByteCode.INVOKEVIRTUAL, 862, 81, 344, 805, 988, 739, FrameMetricsAggregator.EVERY_DURATION, 655, 814, 334, 249, 515, 897, 955, 664, 981, 649, 113, 974, 459, 893, 228, 433, 837, 553, 268, 926, 240, 102, 654, 459, 51, 686, 754, 806, 760, FacebookRequestErrorClassification.ESC_APP_INACTIVE, 403, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, 394, 687, TypedValues.TransitionType.TYPE_DURATION, 946, 670, 656, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 738, 392, 760, 799, 887, 653, 978, 321, 576, 617, 626, 502, 894, 679, 243, 440, 680, 879, ByteCode.MONITORENTER, 572, 640, 724, 926, 56, 204, TypedValues.TransitionType.TYPE_DURATION, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 151, 457, 449, 797, ByteCode.MONITOREXIT, 791, 558, 945, 679, 297, 59, 87, 824, 713, 663, 412, 693, 342, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 134, 108, 571, 364, 631, 212, ByteCode.FRETURN, 643, 304, 329, 343, 97, 430, 751, 497, 314, 983, 374, 822, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 140, 206, 73, 263, 980, 736, 876, 478, 430, 305, 170, 514, 364, 692, 829, 82, 855, 953, 676, 246, 369, 970, 294, 750, 807, 827, 150, 790, 288, 923, 804, 378, 215, 828, 592, 281, 565, AddressConstants.ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES, 710, 82, 896, 831, 547, 261, 524, 462, 293, 465, 502, 56, 661, 821, 976, 991, 658, 869, TypedValues.Custom.TYPE_DIMENSION, 758, 745, ByteCode.INSTANCEOF, 768, 550, TypedValues.MotionType.TYPE_DRAW_PATH, 933, 378, 286, 215, 979, 792, 961, 61, 688, 793, 644, 986, 403, 106, 366, TypedValues.Custom.TYPE_DIMENSION, 644, 372, 567, 466, 434, 645, 210, 389, 550, 919, 135, 780, 773, 635, 389, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 100, 626, 958, 165, 504, 920, ByteCode.ARETURN, ByteCode.INSTANCEOF, 713, 857, 265, 203, 50, 668, 108, 645, 990, 626, ByteCode.MULTIANEWARRAY, TypedValues.PositionType.TYPE_POSITION_TYPE, 357, 358, 850, 858, 364, 936, 638};
}
