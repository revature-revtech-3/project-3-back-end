package com.project3.revtech.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//holds user settings, unknown if used class

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSettings {
	int user_settings_id;
	int user_id;
	String css_mode;
	boolean email_notifications;
}
