ipwebcam = {
	
}

for (var i in ipwebcam_native) {
	ipwebcam[i] = function (ii) {
		return function() {
			return ipwebcam_native[ii].apply(ipwebcam_native, arguments)
		}
	}(i)
}

ipwebcam.load_config = function (def) {
	var ret = ipwebcam_native.load_config()
	if (ret == null) {
		return def
	}
	var s = JSON.parse(ret)
	for (var i in def) {
		if (s[i] == undefined) {
			s[i] = def[i]
		}
	}
	return s
}

ipwebcam.save_config = function(val) {
	ipwebcam_native.save_config(JSON.stringify(val))
}

ipwebcam.on = function(event, callback) {
	ipwebcam_native.on(event, {run: callback})
}
ipwebcam.create_uploader = function(token, callback) {
	ipwebcam_native.create_uploader(token, function(e) {
		if (e.service == null) {
			callback(null)
		} else {
			callback(
				{
					upload: function(filesToUpload, options) {
						if (!options.done) {
							options.done = null;
						}
						if (!options.fail) {
							options.fail = null;
						}
						ipwebcam_native.upload(e.service, e.token, filesToUpload, options.done, options.fail)
					}
				})
		}
	})
}
ipwebcam.authorize = function(userArray) {
	if (!userArray[0]) {
		userArray = [userArray]
	}
	ipwebcam_native.on("webSecurityInitializing", function(e) {
		for (var i = 0; i<userArray.length; ++i) {
			var obj = userArray[i];
			ipwebcam_native.webSecurityAdd(obj.user, obj.password, obj.uri);
		}
	})
}
ipwebcam.set_label = function(text, additional_options) {
	options = {id: 0, x: 0, y: 0, fg: 0xffffffff, bg: 0x0, mpx: 4}
	if (additional_options) {
		for (var i in additional_options) {
			options[i] = additional_options[i]
		}
	}
	ipwebcam_native.set_label(options.id, options.x, options.y, options.fg, options.bg, options.mpx, text)
}
