
/*
'select_video_mode_first'
'unsorted' // videos
'videos_count' %1
'last_entry' %1
'changed' %1
'file_size' %1
translate("cannot_remove_file")
*/

var translate = function(txt, arg1, arg2, arg3) {
	var translated = {
		"exposure_lock_on": "已启用",
		"exposure_lock_off": "禁用",
		"whitebalance_lock_on": "已启用",
		"whitebalance_lock_off": "禁用",

    "orientation_landscape": "横屏",
    "orientation_portrait": "竖屏",
    "orientation_upsidedown": "横屏上下颠倒",
    "orientation_upsidedown_portrait": "竖屏上下颠倒",

    "mirror_flip_none": "无",
    "mirror_flip_mirror": "镜像",
    "mirror_flip_flip": "翻转",
    "mirror_flip_mirror,flip": "镜像, 翻转",

  	"changed": "被更改: %1",
  	"file_size": "文件大小： %1 Mb ",
  	"last_entry": "最后项目： ",
  	"select_video_mode_first": "请先选择视频模式！",
  	"unsorted": "未分类",
  	"videos_count": "文件数: %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "自动",
	  	"whitebalance_cloudy-daylight": "多云",
	  	"whitebalance_daylight": "晴天",
	  	"whitebalance_fluorescent": "荧光灯",
	  	"whitebalance_incandescent": "白炽灯",
	  	"whitebalance_shade": "阴天",
	  	"whitebalance_twilight": "暮光",
	  	"whitebalance_warm-fluorescent": "暖色荧光灯",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "自动",
	  	"flashmode_off": "禁用闪光灯",
	  	"flashmode_on": "开启闪光灯",
	  	"flashmode_red-eye": "防红眼模式",
	  	"flashmode_torch": "手电筒模式",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "手动",
	  	"focusmode_continuous-picture": "激进，用于捕获相片",
	  	"focusmode_continuous-video": "平滑，用于录制视频",
	  	"focusmode_edof": "扩增景深，持续",
	  	"focusmode_fixed": "固定",
	  	"focusmode_infinity": "无限远",
	  	"focusmode_macro": "宏观，手动",
	  	"focusmode_normal": "标准",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "增强现实",
	  	"scenemode_action": "快速运动物体",
	  	"scenemode_asd": "暗景自动感知",
	  	"scenemode_auto": "自动",
	  	"scenemode_backlight": "逆光",
	  	"scenemode_barcode": "读取二维码",
	  	"scenemode_beach": "沙滩",
	  	"scenemode_candlelight": "烛光",
	  	"scenemode_fireworks": "焰火",
	  	"scenemode_flowers": "花朵",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "自然",
	  	"scenemode_night": "夜景",
	  	"scenemode_night-portrait": "夜景人像",
	  	"scenemode_party": "聚会",
	  	"scenemode_portrait": "人像",
	  	"scenemode_snow": "雪景",
	  	"scenemode_sports": "运动",
	  	"scenemode_steadyphoto": "防抖",
	  	"scenemode_sunset": "日落",
	  	"scenemode_theatre": "剧场",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "水印",
	  	"coloreffect_blackboard": "黑板",
	  	"coloreffect_emboss": "浮雕",
	  	"coloreffect_mono": "黑白",
	  	"coloreffect_negative": "负片",
	  	"coloreffect_neon": "氖灯",
	  	"coloreffect_none": "无特效",
	  	"coloreffect_posterize": "色调分离",
	  	"coloreffect_sepia": "怀旧",
	  	"coloreffect_sketch": "素描",
	  	"coloreffect_solarize": "过曝",
	  	"coloreffect_whiteboard": "白板",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Hz",
	  	"antibanding_60hz": "60 Hz",
	  	"antibanding_auto": "自动",
	  	"antibanding_off": "关",
	  	
	"sensor_": "",
	  	"sensor_accel": "加速度传感器",
	  	"sensor_ambient_temp": "环境温度",
	  	"sensor_battery_level": "电池电量",
	  	"sensor_battery_temp": "电池温度",
	  	"sensor_battery_voltage": "电池电压",
	  	"sensor_gravity": "重力传感器",
	  	"sensor_gyro": "陀螺仪",
	  	"sensor_humidity": "相对湿度",
	  	"sensor_light": "光线传感器",
	  	"sensor_lin_accel": "线性加速度",
	  	"sensor_mag": "磁场传感器",
	  	"sensor_motion": "动量",
	  	"sensor_motion_active": "动作活跃",
	  	"sensor_motion_event": "已报告动作",
	  	"sensor_pressure": "压力",
	  	"sensor_proximity": "距离传感器",
	  	"sensor_rot_vector": "旋转矢量",
	  	"sensor_sound": "声音传感器",
	  	"sensor_temp": "温度",
	  	
	"sensor_unit_": "",
	  	"sensor_unit_V": "V",
	  	"sensor_unit_\%": "\%",
	  	"sensor_unit_cm": "cm",
	  	"sensor_unit_dB": "dB",
	  	"sensor_unit_lx": "lux",
	  	"sensor_unit_m/s²": "m/s²",
	  	"sensor_unit_mbar": "mbar",
	  	"sensor_unit_rad/s": "转/秒",
	  	"sensor_unit_µT": "µT",
	  	"sensor_unit_℃": "℃",
	  	
	
	
  
	'#placeholder#': 'none'
  	}[txt]
  	if (translated == undefined)
  		translated = txt;

    return (translated)
      .replace('%1', arg1)
      .replace('%2', arg2)
      .replace('%3', arg3)
}

var minutes_template = "$VAL 分钟";

var time_map = {
	1: "1 分钟",
	5: "5 分钟",
	10: "10 分钟",
	30: "30 分钟",
	60: "1 小时",
	120: "2 小时"
};