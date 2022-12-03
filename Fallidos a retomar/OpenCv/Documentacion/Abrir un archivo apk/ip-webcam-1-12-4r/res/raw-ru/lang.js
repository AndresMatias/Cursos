
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
		"exposure_lock_on": "Включено",
		"exposure_lock_off": "Выключено",
		"whitebalance_lock_on": "Включено",
		"whitebalance_lock_off": "Выключено",

    "orientation_landscape": "Ландшафтная",
    "orientation_portrait": "Портретная",
    "orientation_upsidedown": "Перевернутая",
    "orientation_upsidedown_portrait": "Перевёрнутая портретная",

    "mirror_flip_none": "Нет",
    "mirror_flip_mirror": "Отражение",
    "mirror_flip_flip": "Отразить по вертикали",
    "mirror_flip_mirror,flip": "Отражение, Отразить по вертикали",

  	"changed": "Изменен: %1",
  	"file_size": "Размер файла: %1 Мб ",
  	"last_entry": "Последняя запись: ",
  	"select_video_mode_first": "Выберите режим видео!",
  	"unsorted": "Непомеченное",
  	"videos_count": "Количество файлов: %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "Авто",
	  	"whitebalance_cloudy-daylight": "Облачно",
	  	"whitebalance_daylight": "День",
	  	"whitebalance_fluorescent": "Флуоресцентный",
	  	"whitebalance_incandescent": "Лампа накаливания",
	  	"whitebalance_shade": "Тень",
	  	"whitebalance_twilight": "Сумрак",
	  	"whitebalance_warm-fluorescent": "Тёплый флуорисцент",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "Авто",
	  	"flashmode_off": "Вспышка выключена",
	  	"flashmode_on": "Всегда использовать вспышку",
	  	"flashmode_red-eye": "Против красных глаз",
	  	"flashmode_torch": "Режим фонарика",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "Ручной",
	  	"focusmode_continuous-picture": "Агрессивный, для фото",
	  	"focusmode_continuous-video": "Мягкий, для видео",
	  	"focusmode_edof": "Увеличить поле зрения",
	  	"focusmode_fixed": "Фиксированный",
	  	"focusmode_infinity": "Бесконечный",
	  	"focusmode_macro": "Макро, ручной",
	  	"focusmode_normal": "Нормальный",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "Дополненная реальность",
	  	"scenemode_action": "Быстрое движение",
	  	"scenemode_asd": "Авточувствительность",
	  	"scenemode_auto": "Авто",
	  	"scenemode_backlight": "Задний свет",
	  	"scenemode_barcode": "Чтение штрих-кодов",
	  	"scenemode_beach": "Пляж",
	  	"scenemode_candlelight": "При свечах",
	  	"scenemode_fireworks": "Фейрверки",
	  	"scenemode_flowers": "Цветы",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "Пейзаж",
	  	"scenemode_night": "Ночь",
	  	"scenemode_night-portrait": "Ночной портрет",
	  	"scenemode_party": "Вечеринка",
	  	"scenemode_portrait": "Портрет",
	  	"scenemode_snow": "Снег",
	  	"scenemode_sports": "Спорт",
	  	"scenemode_steadyphoto": "Против размытия",
	  	"scenemode_sunset": "Закат",
	  	"scenemode_theatre": "Театр",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "Под водой",
	  	"coloreffect_blackboard": "Чёрная доска",
	  	"coloreffect_emboss": "Рельеф",
	  	"coloreffect_mono": "Чёрно-белый",
	  	"coloreffect_negative": "Негатив",
	  	"coloreffect_neon": "Неон",
	  	"coloreffect_none": "Нет эффектов",
	  	"coloreffect_posterize": "Постеризация",
	  	"coloreffect_sepia": "Сепия",
	  	"coloreffect_sketch": "Эскиз",
	  	"coloreffect_solarize": "Соляризация",
	  	"coloreffect_whiteboard": "Белая доска",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Гц",
	  	"antibanding_60hz": "60 Гц",
	  	"antibanding_auto": "Авто",
	  	"antibanding_off": "Выключена",
	  	
	"sensor_": "",
	  	"sensor_accel": "Акселерометр",
	  	"sensor_ambient_temp": "Температура окружающей среды",
	  	"sensor_battery_level": "Уровень заряда батареи",
	  	"sensor_battery_temp": "Температура батареи",
	  	"sensor_battery_voltage": "Вольтметр батареи",
	  	"sensor_gravity": "Датчик гравитации",
	  	"sensor_gyro": "Гироскоп",
	  	"sensor_humidity": "Относительная влажность",
	  	"sensor_light": "Датчик освещения",
	  	"sensor_lin_accel": "Линейное ускорение",
	  	"sensor_mag": "Магнитное поле",
	  	"sensor_motion": "Количество движения",
	  	"sensor_motion_active": "Движение регистрируется",
	  	"sensor_motion_event": "Движение обнаружено",
	  	"sensor_pressure": "Давление",
	  	"sensor_proximity": "Датчик близости",
	  	"sensor_rot_vector": "Вектор поворота",
	  	"sensor_sound": "Датчик звука",
	  	"sensor_temp": "Температура",
	  	
	"sensor_unit_": "",
	  	"sensor_unit_V": "В",
	  	"sensor_unit_\%": "\%",
	  	"sensor_unit_cm": "см",
	  	"sensor_unit_dB": "дБ",
	  	"sensor_unit_lx": "лк",
	  	"sensor_unit_m/s²": "м/с²",
	  	"sensor_unit_mbar": "мбар",
	  	"sensor_unit_rad/s": "рад/с",
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

var minutes_template = "$VAL минут";

var time_map = {
	1: "1 минуте",
	5: "5 минут",
	10: "10 минут",
	30: "30 минут",
	60: "1 час",
	120: "2 часа"
};