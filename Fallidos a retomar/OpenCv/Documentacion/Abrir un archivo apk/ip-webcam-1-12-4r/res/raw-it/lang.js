
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
		"exposure_lock_on": "Attiva",
		"exposure_lock_off": "Disabilitato",
		"whitebalance_lock_on": "Attiva",
		"whitebalance_lock_off": "Disabilitato",

    "orientation_landscape": "Paesaggio",
    "orientation_portrait": "Ritratto",
    "orientation_upsidedown": "Su e giù",
    "orientation_upsidedown_portrait": "Ritratto su e giù",

    "mirror_flip_none": "Nessuna",
    "mirror_flip_mirror": "Specchio",
    "mirror_flip_flip": "Flip",
    "mirror_flip_mirror,flip": "Specchio, Flip",

  	"changed": "Cambiato: %1",
  	"file_size": "Dimensione del file: %1 Mb ",
  	"last_entry": "Ultimo entrato: ",
  	"select_video_mode_first": "Selezionare prima  il video!",
  	"unsorted": "Indifferenziati",
  	"videos_count": "Files: %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "Auto",
	  	"whitebalance_cloudy-daylight": "nuvoloso",
	  	"whitebalance_daylight": "Luce giorno",
	  	"whitebalance_fluorescent": "Fluorescente",
	  	"whitebalance_incandescent": "Incandescente",
	  	"whitebalance_shade": "Ombra",
	  	"whitebalance_twilight": "Crepuscolo",
	  	"whitebalance_warm-fluorescent": "Fluorescente caldo",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "Flash automatico",
	  	"flashmode_off": "Flash disabilitato",
	  	"flashmode_on": "Flash sempre abilitato",
	  	"flashmode_red-eye": "Modalità riduzione occhi rossi",
	  	"flashmode_torch": "Modo flash",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "Manuale",
	  	"focusmode_continuous-picture": "Aggressivo, per scattare foto",
	  	"focusmode_continuous-video": "Regolare, per la registrazione video",
	  	"focusmode_edof": "Profondità di campo estesa, continua",
	  	"focusmode_fixed": "Fisso",
	  	"focusmode_infinity": "Infinito",
	  	"focusmode_macro": "Macro, manuale",
	  	"focusmode_normal": "Normale",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "Realtà aumentata",
	  	"scenemode_action": "Oggetti in movimento",
	  	"scenemode_asd": "Autosense buio",
	  	"scenemode_auto": "Automatico",
	  	"scenemode_backlight": "Retro illuminazione",
	  	"scenemode_barcode": "Lettore barcode",
	  	"scenemode_beach": "Spiaggia",
	  	"scenemode_candlelight": "Lume di candela",
	  	"scenemode_fireworks": "Fuochi d'artificio",
	  	"scenemode_flowers": "Fiori",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "Paesaggio",
	  	"scenemode_night": "Notte",
	  	"scenemode_night-portrait": "Ritratto notte",
	  	"scenemode_party": "Festa",
	  	"scenemode_portrait": "Ritratto",
	  	"scenemode_snow": "Neve",
	  	"scenemode_sports": "Sport",
	  	"scenemode_steadyphoto": "Fermo immagine",
	  	"scenemode_sunset": "Tramonto",
	  	"scenemode_theatre": "Teatro",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "Acqua",
	  	"coloreffect_blackboard": "Lavagna",
	  	"coloreffect_emboss": "Rilievo",
	  	"coloreffect_mono": "Bianco e nero",
	  	"coloreffect_negative": "Negativo",
	  	"coloreffect_neon": "Neon",
	  	"coloreffect_none": "Nessun effetto",
	  	"coloreffect_posterize": "Posterizatione",
	  	"coloreffect_sepia": "Seppia",
	  	"coloreffect_sketch": "Schizzo",
	  	"coloreffect_solarize": "Solarizatione",
	  	"coloreffect_whiteboard": "Lavagna",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Hz",
	  	"antibanding_60hz": "60 Hz",
	  	"antibanding_auto": "Auto",
	  	"antibanding_off": "Off",
	  	
	"sensor_": "",
	  	"sensor_accel": "Accelerometro",
	  	"sensor_ambient_temp": "Temperatura ambiente",
	  	"sensor_battery_level": "Livello batteria",
	  	"sensor_battery_temp": "Temperatura della batteria",
	  	"sensor_battery_voltage": "Tensione della batteria",
	  	"sensor_gravity": "Sensore di gravità",
	  	"sensor_gyro": "Giroscopio",
	  	"sensor_humidity": "Umidità relativa",
	  	"sensor_light": "Sensore di luce",
	  	"sensor_lin_accel": "Accelerazione lineare",
	  	"sensor_mag": "Campo magnetico",
	  	"sensor_motion": "Quantità di movimento",
	  	"sensor_motion_active": "Movimento attivo",
	  	"sensor_motion_event": "Movimento segnalato",
	  	"sensor_pressure": "Pressione",
	  	"sensor_proximity": "Sensore di prossimità",
	  	"sensor_rot_vector": "Vettore di rotazione",
	  	"sensor_sound": "Sensore audio",
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

var minutes_template = "$VAL minuti";

var time_map = {
	1: "1 minuto",
	5: "5 minuti",
	10: "10 minuti",
	30: "30 minuti",
	60: "1 ora",
	120: "2 ore"
};