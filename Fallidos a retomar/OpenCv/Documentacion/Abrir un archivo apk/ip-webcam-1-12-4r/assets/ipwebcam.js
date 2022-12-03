ipwebcam = {
	load_config: function (def) {
		var s = JSON.stringify(def)
		s = ipwebcam_native.load_config(s)
		s = JSON.parse(s)
		for (var i in def) {
			if (s[i] == undefined) {
				s[i] = def[i]
			}
		}
		return s
	},
	save_config: function(def) {
		var s = JSON.stringify(def)
		s = ipwebcam_native.save_config(s)
	},
	get_file_service: function(oldToken, filter, callback) {
		filter = JSON.stringify(filter)
		$jsCallback = callback
		ipwebcam_native.get_file_service(oldToken, filter, "$jsCallback")
	},
	lang: ipwebcam_native.get_lang()
}