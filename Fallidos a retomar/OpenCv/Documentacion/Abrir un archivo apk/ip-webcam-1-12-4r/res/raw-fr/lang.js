
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
		"exposure_lock_on": "Activé",
		"exposure_lock_off": "Désactivé",
		"whitebalance_lock_on": "Activé",
		"whitebalance_lock_off": "Désactivé",

    "orientation_landscape": "Paysage",
    "orientation_portrait": "Portrait",
    "orientation_upsidedown": "A l'envers",
    "orientation_upsidedown_portrait": "Portrait à l'envers",

    "mirror_flip_none": "Aucun",
    "mirror_flip_mirror": "Mirror",
    "mirror_flip_flip": "Retourner",
    "mirror_flip_mirror,flip": "Mirror, Retourner",

  	"changed": "Modifier : %1",
  	"file_size": "Taille du fichier : %1 Mb ",
  	"last_entry": "Dernière entrée : ",
  	"select_video_mode_first": "Sélectionnez le mode vidéo en premier !",
  	"unsorted": "Non triés",
  	"videos_count": "Fichiers : %1",
  	
  	
  	"whitebalance_": "",
	  	"whitebalance_auto": "Auto",
	  	"whitebalance_cloudy-daylight": "Nuageux",
	  	"whitebalance_daylight": "Lumière du jour",
	  	"whitebalance_fluorescent": "Fluorescent",
	  	"whitebalance_incandescent": "Incandescent",
	  	"whitebalance_shade": "Ombrager",
	  	"whitebalance_twilight": "Crépuscule",
	  	"whitebalance_warm-fluorescent": "Fluorescent chaud",
	  	
	"flashmode_": "",
	  	"flashmode_auto": "Flash auto",
	  	"flashmode_off": "Flash désactivé",
	  	"flashmode_on": "Toujours utiliser le flash",
	  	"flashmode_red-eye": "Réduction des yeux rouges",
	  	"flashmode_torch": "Mode lampe de poche",
	  	
	"focusmode_": "",
	  	"focusmode_auto": "Manuel",
	  	"focusmode_continuous-picture": "Agressif, pour prendre des photos",
	  	"focusmode_continuous-video": "Doux, pour l'enregistrement vidéo",
	  	"focusmode_edof": "Profondeur de champ étendue, continue",
	  	"focusmode_fixed": "Fixe",
	  	"focusmode_infinity": "Infini",
	  	"focusmode_macro": "Macro, manuel",
	  	"focusmode_normal": "Normal",
	  	
	"scenemode_": "",
	  	"scenemode_AR": "Réalité augmenté",
	  	"scenemode_action": "Objets en déplacement rapide",
	  	"scenemode_asd": "Détection automatique de l'obscurité",
	  	"scenemode_auto": "Auto",
	  	"scenemode_backlight": "Rétro-éclairage",
	  	"scenemode_barcode": "Lecture de code barre",
	  	"scenemode_beach": "Plage",
	  	"scenemode_candlelight": "Lumière de bougie",
	  	"scenemode_fireworks": "Feu d'artifice",
	  	"scenemode_flowers": "Fleurs",
	  	"scenemode_hdr": "HDR",
	  	"scenemode_landscape": "Paysage",
	  	"scenemode_night": "Nuit",
	  	"scenemode_night-portrait": "Portrait de nuit",
	  	"scenemode_party": "Partie",
	  	"scenemode_portrait": "Portrait",
	  	"scenemode_snow": "Neige",
	  	"scenemode_sports": "Sports",
	  	"scenemode_steadyphoto": "Éviter les photos floues",
	  	"scenemode_sunset": "Couché de soleil",
	  	"scenemode_theatre": "Théâtre",
	  	
	"coloreffect_": "",
	  	"coloreffect_aqua": "Eau",
	  	"coloreffect_blackboard": "Tableau noir",
	  	"coloreffect_emboss": "Gaufrage",
	  	"coloreffect_mono": "Noir et blanc",
	  	"coloreffect_negative": "Négatif",
	  	"coloreffect_neon": "Neon",
	  	"coloreffect_none": "Pas d'effets",
	  	"coloreffect_posterize": "Postérisation",
	  	"coloreffect_sepia": "Sépia",
	  	"coloreffect_sketch": "Dessin",
	  	"coloreffect_solarize": "Solarisation",
	  	"coloreffect_whiteboard": "Tableau blanc",
	  	
	"antibanding_": "",
	  	"antibanding_50hz": "50 Hz",
	  	"antibanding_60hz": "60 Hz",
	  	"antibanding_auto": "Auto",
	  	"antibanding_off": "Off",
	  	
	"sensor_": "",
	  	"sensor_accel": "Accéléromètre",
	  	"sensor_ambient_temp": "Température ambiante",
	  	"sensor_battery_level": "Niveau de la batterie",
	  	"sensor_battery_temp": "Température de la batterie",
	  	"sensor_battery_voltage": "Tension de la batterie",
	  	"sensor_gravity": "Capteur de gravité",
	  	"sensor_gyro": "Gyroscope",
	  	"sensor_humidity": "Humidité relative",
	  	"sensor_light": "Capteur de luminosité",
	  	"sensor_lin_accel": "Accélération linéaire",
	  	"sensor_mag": "Champ magnétique",
	  	"sensor_motion": "Quantité de mouvement",
	  	"sensor_motion_active": "Déplacement actif",
	  	"sensor_motion_event": "Déplacement rapporté",
	  	"sensor_pressure": "Pression",
	  	"sensor_proximity": "Capteur de proximité",
	  	"sensor_rot_vector": "Vecteur de rotation",
	  	"sensor_sound": "Capteur audio",
	  	"sensor_temp": "Température",
	  	
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

var minutes_template = "$VAL minutes";

var time_map = {
	1: "1 minute",
	5: "5 minutes",
	10: "10 minutes",
	30: "30 minutes",
	60: "1 heure",
	120: "2 heures"
};