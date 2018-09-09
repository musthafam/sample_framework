package com.testscripts.practise.forms;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.forms.pages.DragAndDropPage;
import com.practice.framework.utils.DriverUtils;

public class DragAndDropTest extends DriverUtils{

	@Test
	public void sampleDragAndDropTest() {
		DragAndDropPage dragPage = new DragAndDropPage();
		dragPage.loadPage();
		Assert.assertEquals(dragPage.getTextFromTarget(), "Drop here");
		dragPage.dragAndDrop();
		Assert.assertEquals(dragPage.getTextFromTarget(), "Dropped!");
	}
}
