
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
		"exposure_lock_on": "Włączone",
		"exposure_lock_off": "Wyłączone",
		"whitebalance_lock_on": "Włączone",
		"whitebalance_lock_off": "Wyłączone",

    "orientation_landscape": "Krajobraz",
    "orientation_portrait": "Portret",
    "orientation_upsidedown": "Na odwrót",
    "orientation_upsidedown_portrait": "Portret odwrócony",

    "mirror_flip_none": "Brak",
    "mirror_flip_mirror": "Lustro",
    "mirror_flip_flip": "Odbicie",
    "mirror_flip_mirror,flip": "Lustro, Odbicie",

  	"changed": "Modyfikacja: %1",
  	"file_size": "Rozmiar pliku: %1 Mb ",
  	"last_entry": "Ostatni wpis: ",
  	"select_video_mode_first": "Wybierz najpierw tryb video!",
  	"unsorted": "Nieuporządkowane",
  	"videos_count": "Plików: %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "Auto",
	  	"whitebalance_cloudy-daylight": "Zachmurzony dzień",
	  	"whitebalance_daylight": "Światło dzienne",
	  	"whitebalance_fluorescent": "Światło fluorescencyjne",
	  	"whitebalance_incandescent": "Światło żarowe",
	  	"whitebalance_shade": "Cień",
	  	"whitebalance_twilight": "Półmrok",
	  	"whitebalance_warm-fluorescent": "Ciepłe fluorescencyjne",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "Automatyczna lampa",
	  	"flashmode_off": "Lampa wyłączona",
	  	"flashmode_on": "Zawsze używaj lampy",
	  	"flashmode_red-eye": "Redukcja efektu czerwonych oczu",
	  	"flashmode_torch": "Tryb lampy błyskowej",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "Ręczny",
	  	"focusmode_continuous-picture": "Agresywny, do zdjęć",
	  	"focusmode_continuous-video": "Płynny, do nagrywania",
	  	"focusmode_edof": "Rozszerzona głębia, ciągły",
	  	"focusmode_fixed": "Stały",
	  	"focusmode_infinity": "Nieskończoność",
	  	"focusmode_macro": "Makro, ręczny",
	  	"focusmode_normal": "Normalny",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "Rozszerzona rzeczywistość",
	  	"scenemode_action": "Szybkie obiekty",
	  	"scenemode_asd": "Wykrywanie ciemności",
	  	"scenemode_auto": "Auto",
	  	"scenemode_backlight": "Światło z tyłu",
	  	"scenemode_barcode": "Odczyt kodu kreskowego",
	  	"scenemode_beach": "Plaża",
	  	"scenemode_candlelight": "Światło świec",
	  	"scenemode_fireworks": "Fajerwerki",
	  	"scenemode_flowers": "Kwiat",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "Krajobraz",
	  	"scenemode_night": "Noc",
	  	"scenemode_night-portrait": "Portret w nocy",
	  	"scenemode_party": "Imprezka",
	  	"scenemode_portrait": "Portret",
	  	"scenemode_snow": "Śnieg",
	  	"scenemode_sports": "Sport",
	  	"scenemode_steadyphoto": "Zmniejsz rozmycie zdjęć",
	  	"scenemode_sunset": "Wschód słońca",
	  	"scenemode_theatre": "Teatr",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "Woda",
	  	"coloreffect_blackboard": "Efekt Blackboard",
	  	"coloreffect_emboss": "Wytłaczanie",
	  	"coloreffect_mono": "Czarno-biały",
	  	"coloreffect_negative": "Negatyw",
	  	"coloreffect_neon": "Neon",
	  	"coloreffect_none": "Brak efektów",
	  	"coloreffect_posterize": "Posteryzacja",
	  	"coloreffect_sepia": "Sepia",
	  	"coloreffect_sketch": "Szkic",
	  	"coloreffect_solarize": "Solaryzacja",
	  	"coloreffect_whiteboard": "Efekt Whiteboard",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Hz",
	  	"antibanding_60hz": "60 Hz",
	  	"antibanding_auto": "Auto",
	  	"antibanding_off": "Wyłączony",
	  	
	"sensor_": "",
	  	"sensor_accel": "Akcelerometr",
	  	"sensor_ambient_temp": "Temperatura otoczenia",
	  	"sensor_battery_level": "Poziom naładowania akumulatora",
	  	"sensor_battery_temp": "Temperatura akumulatora",
	  	"sensor_battery_voltage": "Napięcie akumulatora",
	  	"sensor_gravity": "Czujnik grawitacyjny",
	  	"sensor_gyro": "Żyroskop",
	  	"sensor_humidity": "Wilgotność względna",
	  	"sensor_light": "Czujnik światła",
	  	"sensor_lin_accel": "Przyspieszenie liniowe",
	  	"sensor_mag": "Pole magnetyczne",
	  	"sensor_motion": "Ilość ruchu",
	  	"sensor_motion_active": "Ruch aktywny",
	  	"sensor_motion_event": "Zgłoszony ruch",
	  	"sensor_pressure": "Ciśnienie",
	  	"sensor_proximity": "Czujnik zbliżeniowy",
	  	"sensor_rot_vector": "Wektor obrotu",
	  	"sensor_sound": "Czujnik dźwięku",
	  	"sensor_temp": "Temperatura",
	  	
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

var minutes_template = "$VAL minut";

var time_map = {
	1: "1 minuta",
	5: "5 minut",
	10: "10 minut",
	30: "30 minut",
	60: "1 godzina",
	120: "2 godziny"
};