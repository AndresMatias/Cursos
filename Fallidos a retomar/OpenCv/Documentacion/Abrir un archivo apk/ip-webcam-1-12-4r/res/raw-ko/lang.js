
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
		"exposure_lock_on": "활성",
		"exposure_lock_off": "금지",
		"whitebalance_lock_on": "활성",
		"whitebalance_lock_off": "금지",

    "orientation_landscape": "가로 보기",
    "orientation_portrait": "세로 보기",
    "orientation_upsidedown": "상하반전",
    "orientation_upsidedown_portrait": "상하반전 세로 보기",

    "mirror_flip_none": "없음",
    "mirror_flip_mirror": "미러효과",
    "mirror_flip_flip": "뒤집기",
    "mirror_flip_mirror,flip": "미러효과, 뒤집기",

  	"changed": "바뀜: %1",
  	"file_size": "파일용량: %1 Mb ",
  	"last_entry": "최종 번호: ",
  	"select_video_mode_first": "비디오 모드를 먼저 선택해 주세요!",
  	"unsorted": "정렬 안됨",
  	"videos_count": "Files: %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "자동",
	  	"whitebalance_cloudy-daylight": "구름낀 낮",
	  	"whitebalance_daylight": "낮",
	  	"whitebalance_fluorescent": "형광등",
	  	"whitebalance_incandescent": "전구색",
	  	"whitebalance_shade": "그늘",
	  	"whitebalance_twilight": "해질 녘",
	  	"whitebalance_warm-fluorescent": "주광색",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "자동 플래쉬",
	  	"flashmode_off": "플래쉬 금지",
	  	"flashmode_on": "항상 플래쉬 사용",
	  	"flashmode_red-eye": "적목감소 모드",
	  	"flashmode_torch": "플래쉬 라이트 모드",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "자동",
	  	"focusmode_continuous-picture": "거칠게, 사진 찍기 위한",
	  	"focusmode_continuous-video": "부드럽게, 녹화를 위한",
	  	"focusmode_edof": "또렷하게, 연속장면을 위한",
	  	"focusmode_fixed": "고정",
	  	"focusmode_infinity": "무한대",
	  	"focusmode_macro": "매크로, 수동",
	  	"focusmode_normal": "일반",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "Augmented reality",
	  	"scenemode_action": "움직이는 물체",
	  	"scenemode_asd": "어둠 자동감지",
	  	"scenemode_auto": "자동",
	  	"scenemode_backlight": "배경",
	  	"scenemode_barcode": "바코드 읽기",
	  	"scenemode_beach": "해변",
	  	"scenemode_candlelight": "양초 불빛",
	  	"scenemode_fireworks": "불꽃놀이",
	  	"scenemode_flowers": "꽃",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "풍경",
	  	"scenemode_night": "야간",
	  	"scenemode_night-portrait": "야간 인물화",
	  	"scenemode_party": "파티",
	  	"scenemode_portrait": "인물화",
	  	"scenemode_snow": "눈",
	  	"scenemode_sports": "스포츠",
	  	"scenemode_steadyphoto": "흐릿함 방지",
	  	"scenemode_sunset": "일몰",
	  	"scenemode_theatre": "극장",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "아쿠아",
	  	"coloreffect_blackboard": "검게 처리",
	  	"coloreffect_emboss": "엠보싱",
	  	"coloreffect_mono": "흑백모드",
	  	"coloreffect_negative": "반전",
	  	"coloreffect_neon": "네온",
	  	"coloreffect_none": "효과 없음",
	  	"coloreffect_posterize": "포스터처럼",
	  	"coloreffect_sepia": "세피아",
	  	"coloreffect_sketch": "스케치",
	  	"coloreffect_solarize": "태양처럼 강하게",
	  	"coloreffect_whiteboard": "화이트보드",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Hz",
	  	"antibanding_60hz": "60 Hz",
	  	"antibanding_auto": "자동",
	  	"antibanding_off": "꺼짐",
	  	
	"sensor_": "",
	  	"sensor_accel": "가속계",
	  	"sensor_ambient_temp": "주변 온도",
	  	"sensor_battery_level": "배터리 레벨",
	  	"sensor_battery_temp": "배터리 온도",
	  	"sensor_battery_voltage": "배터리 전압",
	  	"sensor_gravity": "중력 센서",
	  	"sensor_gyro": "자이로 스코프",
	  	"sensor_humidity": "상대 습도",
	  	"sensor_light": "명암 센서",
	  	"sensor_lin_accel": "리니어 액셀",
	  	"sensor_mag": "자장계",
	  	"sensor_motion": "모션량",
	  	"sensor_motion_active": "모션 동작함",
	  	"sensor_motion_event": "모션 보고됨",
	  	"sensor_pressure": "압력",
	  	"sensor_proximity": "근접 센서",
	  	"sensor_rot_vector": "로테이션 벡터",
	  	"sensor_sound": "오디오 센서",
	  	"sensor_temp": "온도",
	  	
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

var minutes_template = "$VAL 분";

var time_map = {
	1: "1분",
	5: "5분",
	10: "10분",
	30: "30분",
	60: "1시간",
	120: "2시간"
};