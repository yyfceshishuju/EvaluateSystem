package com.zpark.dao;

import com.zpark.entity.Assistant;

public interface AssistantDAO {
		public Assistant queryAssistantById(int id);
		public Assistant queryAssistantByUsername(String username);
		public void updateAssistant(Assistant assistant);
}
