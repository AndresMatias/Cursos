
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
		"exposure_lock_on": "Aktiviert",
		"exposure_lock_off": "Deaktiviert",
		"whitebalance_lock_on": "Aktiviert",
		"whitebalance_lock_off": "Deaktiviert",

    "orientation_landscape": "ungedreht (wie Vorschau)",
    "orientation_portrait": "90° gedreht",
    "orientation_upsidedown": "180° gedreht",
    "orientation_upsidedown_portrait": "270° gedreht",

    "mirror_flip_none": "Nichts",
    "mirror_flip_mirror": "Spiegeln",
    "mirror_flip_flip": "Seitenwechsel",
    "mirror_flip_mirror,flip": "Spiegeln, Seitenwechsel",

  	"changed": "Geändert: %1",
  	"file_size": "Dateigröße: %1 MB ",
  	"last_entry": "Letzter Eintrag: ",
  	"select_video_mode_first": "Zuerst den Videomodus auswählen!",
  	"unsorted": "Unsortiert",
  	"videos_count": "Dateien: %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "Automatik",
	  	"whitebalance_cloudy-daylight": "Bewölktes Tageslicht",
	  	"whitebalance_daylight": "Tageslicht",
	  	"whitebalance_fluorescent": "Fluoreszierend",
	  	"whitebalance_incandescent": "Glühend",
	  	"whitebalance_shade": "Schatten",
	  	"whitebalance_twilight": "Dämmerung",
	  	"whitebalance_warm-fluorescent": "Warm fluoreszierend",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "Automatischer Blitz",
	  	"flashmode_off": "Blitz deaktiviert",
	  	"flashmode_on": "Blitz immer benutzen",
	  	"flashmode_red-eye": "Reduktionsmodus für rote Augen",
	  	"flashmode_torch": "Blitzlicht Modus",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "Manuell",
	  	"focusmode_continuous-picture": "Aggressiv, für Fotoaufnahmen",
	  	"focusmode_continuous-video": "Glatt, für Videoaufzeichnungen",
	  	"focusmode_edof": "erweitere Feldtiefe",
	  	"focusmode_fixed": "Fixiert",
	  	"focusmode_infinity": "Unendlich",
	  	"focusmode_macro": "Macromodus, manuell",
	  	"focusmode_normal": "Normal",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "(AR) Augmented Reality",
	  	"scenemode_action": "Schnell bewegende Objekte",
	  	"scenemode_asd": "Autosense Dunkelheit",
	  	"scenemode_auto": "Automatisch",
	  	"scenemode_backlight": "Rücklicht",
	  	"scenemode_barcode": "Barcode lesen",
	  	"scenemode_beach": "Strand",
	  	"scenemode_candlelight": "Kerzenlicht",
	  	"scenemode_fireworks": "Feuerwerk",
	  	"scenemode_flowers": "Blumen",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "Landschaft",
	  	"scenemode_night": "Nacht",
	  	"scenemode_night-portrait": "Nacht Porträt",
	  	"scenemode_party": "Party",
	  	"scenemode_portrait": "Portrait",
	  	"scenemode_snow": "Schnee",
	  	"scenemode_sports": "Sport",
	  	"scenemode_steadyphoto": "Vermeiden Sie unscharfe Bilder",
	  	"scenemode_sunset": "Sonnenuntergang",
	  	"scenemode_theatre": "Theater",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "Aqua",
	  	"coloreffect_blackboard": "Tafel",
	  	"coloreffect_emboss": "Embossing",
	  	"coloreffect_mono": "Schwarz-Weiß",
	  	"coloreffect_negative": "Negativ",
	  	"coloreffect_neon": "Neon",
	  	"coloreffect_none": "keine Effekte",
	  	"coloreffect_posterize": "Posterization",
	  	"coloreffect_sepia": "Sepia",
	  	"coloreffect_sketch": "Sketch",
	  	"coloreffect_solarize": "Solarisation",
	  	"coloreffect_whiteboard": "Whiteboard",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Hz",
	  	"antibanding_60hz": "60 Hz",
	  	"antibanding_auto": "Automatisch",
	  	"antibanding_off": "Aus",
	  	
	"sensor_": "",
	  	"sensor_accel": "Beschleunigungssensor",
	  	"sensor_ambient_temp": "Umgebungstemperatur",
	  	"sensor_battery_level": "Batterieladung",
	  	"sensor_battery_temp": "Batterietemperatur",
	  	"sensor_battery_voltage": "Batteriespannung",
	  	"sensor_gravity": "Schwerkraftsensor",
	  	"sensor_gyro": "Gyroskop",
	  	"sensor_humidity": "Relative Luftfeuchtigkeit",
	  	"sensor_light": "Lichtsensor",
	  	"sensor_lin_accel": "Beschleuningung",
	  	"sensor_mag": "Magnetfeldsensor",
	  	"sensor_motion": "Bewegungsmenge",
	  	"sensor_motion_active": "Bewegung erkannt",
	  	"sensor_motion_event": "Bewegung gemeldet",
	  	"sensor_pressure": "Druck",
	  	"sensor_proximity": "Näherungssensor",
	  	"sensor_rot_vector": "Rotationsvektor",
	  	"sensor_sound": "Akustiksensor",
	  	"sensor_temp": "Temperatur",
	  	
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

var minutes_template = "$VAL Minuten";

var time_map = {
	1: "1 Minute",
	5: "5 Minuten",
	10: "10 Minuten",
	30: "30 Minuten",
	60: "1 Stunde",
	120: "2 Stunden"
};