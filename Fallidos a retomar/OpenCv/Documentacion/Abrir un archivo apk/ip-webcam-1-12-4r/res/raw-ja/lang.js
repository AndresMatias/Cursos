
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
		"exposure_lock_on": "有効",
		"exposure_lock_off": "無効",
		"whitebalance_lock_on": "有効",
		"whitebalance_lock_off": "無効",

    "orientation_landscape": "横表示",
    "orientation_portrait": "縦表示",
    "orientation_upsidedown": "横表示で上下反転",
    "orientation_upsidedown_portrait": "縦表示で上下反転",

    "mirror_flip_none": "無し",
    "mirror_flip_mirror": "左右反転",
    "mirror_flip_flip": "上下反転",
    "mirror_flip_mirror,flip": "左右反転, 上下反転",

  	"changed": "変更: %1",
  	"file_size": "ファイルサイズ: %1 Mb ",
  	"last_entry": "最新更新日時: ",
  	"select_video_mode_first": "ビデオモードを先に選択してください",
  	"unsorted": "分類されていません",
  	"videos_count": "ファイル: %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "自動",
	  	"whitebalance_cloudy-daylight": "曇り",
	  	"whitebalance_daylight": "自然光",
	  	"whitebalance_fluorescent": "蛍光灯",
	  	"whitebalance_incandescent": "白熱灯",
	  	"whitebalance_shade": "日陰",
	  	"whitebalance_twilight": "トワイライト",
	  	"whitebalance_warm-fluorescent": "暖色蛍光灯",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "自動フラッシュ",
	  	"flashmode_off": "フラッシュ無効",
	  	"flashmode_on": "フラッシュ有効",
	  	"flashmode_red-eye": "赤目軽減モード",
	  	"flashmode_torch": "フラッシュライトモード",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "マニュアル",
	  	"focusmode_continuous-picture": "オートフォーカス（写真撮影用）",
	  	"focusmode_continuous-video": "オートフォーカス（映像撮影用）",
	  	"focusmode_edof": "被写体深度",
	  	"focusmode_fixed": "固定",
	  	"focusmode_infinity": "無限遠",
	  	"focusmode_macro": "マクロ",
	  	"focusmode_normal": "ノーマル",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "AR機能",
	  	"scenemode_action": "動きの早い被写体",
	  	"scenemode_asd": "暗闇自動感知",
	  	"scenemode_auto": "オート",
	  	"scenemode_backlight": "ブラックライト",
	  	"scenemode_barcode": "バーコード読み取り",
	  	"scenemode_beach": "ビーチ",
	  	"scenemode_candlelight": "キャンドルライト",
	  	"scenemode_fireworks": "花火",
	  	"scenemode_flowers": "花",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "景色",
	  	"scenemode_night": "夜景",
	  	"scenemode_night-portrait": "人物夜景",
	  	"scenemode_party": "パーティー",
	  	"scenemode_portrait": "人物",
	  	"scenemode_snow": "雪",
	  	"scenemode_sports": "スポーツ",
	  	"scenemode_steadyphoto": "ぼやけ防止",
	  	"scenemode_sunset": "夕陽",
	  	"scenemode_theatre": "シアター",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "アクア",
	  	"coloreffect_blackboard": "黒板",
	  	"coloreffect_emboss": "浮き出し加工",
	  	"coloreffect_mono": "白黒",
	  	"coloreffect_negative": "ネガティブ",
	  	"coloreffect_neon": "ネオン",
	  	"coloreffect_none": "エフェクトなし",
	  	"coloreffect_posterize": "減色フィルター",
	  	"coloreffect_sepia": "セピア",
	  	"coloreffect_sketch": "スケッチ",
	  	"coloreffect_solarize": "太陽光",
	  	"coloreffect_whiteboard": "ホワイトボード",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Hz",
	  	"antibanding_60hz": "60 Hz",
	  	"antibanding_auto": "オート",
	  	"antibanding_off": "オフ",
	  	
	"sensor_": "",
	  	"sensor_accel": "加速度計",
	  	"sensor_ambient_temp": "周辺温度",
	  	"sensor_battery_level": "電源残量",
	  	"sensor_battery_temp": "バッテリー温度",
	  	"sensor_battery_voltage": "電源電圧",
	  	"sensor_gravity": "重力センサー",
	  	"sensor_gyro": "ジャイロセンサー",
	  	"sensor_humidity": "湿度",
	  	"sensor_light": "明るさセンサー",
	  	"sensor_lin_accel": "直線加速度",
	  	"sensor_mag": "磁場",
	  	"sensor_motion": "動作量",
	  	"sensor_motion_active": "動作起動",
	  	"sensor_motion_event": "動作報告",
	  	"sensor_pressure": "気圧",
	  	"sensor_proximity": "近接センター",
	  	"sensor_rot_vector": "回転ベクトル",
	  	"sensor_sound": "音声センサー",
	  	"sensor_temp": "温度",
	  	
	"sensor_unit_": "",
	  	"sensor_unit_V": "V",
	  	"sensor_unit_\%": "\%",
	  	"sensor_unit_cm": "cm",
	  	"sensor_unit_dB": "dB",
	  	"sensor_unit_lx": "lx",
	  	"sensor_unit_m/s²": "m/s²",
	  	"sensor_unit_mbar": "mbar",
	  	"sensor_unit_rad/s": "rad/s",
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

var minutes_template = "$VAL 分";

var time_map = {
	1: "1分",
	5: "5分",
	10: "10分",
	30: "30分",
	60: "1時間",
	120: "2時間"
};