package com.github.ykrasik.jaci;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.github.ykrasik.jaci.cli.libgdx.LibGdxCli;
import com.github.ykrasik.jaci.cli.libgdx.LibGdxCliBuilder;
import com.github.ykrasik.jaci.cli.libgdx.LibGdxVisibilityToggler;
import com.github.ykrasik.jaci.commands.*;

/**
 * Example usage of LibGdx CLI, using the LibGdx reflection API
 * (compatible with GWT, but offers limited reflection features).
 *
 * Java reflection API is supplied by the dependency 'jaci-libgdx-cli-gwt' our build.gradle file
 *
 * To run GWT:
 * gradlew html:superDev
 * and then navigate to http://localhost:8080/html/
 *
 * @author Yevgeny Krasik
 */
public class JaciLibGdxExample extends ApplicationAdapter {
	private Stage stage;

	@Override
	public void create() {
		final LibGdxCli cli = new LibGdxCliBuilder()
			.processClasses(BasicCommands.class, PathCommands1.class, PathCommands2.class)
			// Can also process objects instead of classes.
			.process(new MandatoryParamsCommands(), new OptionalParamsCommands(), new StringParamCommands())
			.processClasses(EnumCommands.class, InnerClassCommands.class)
			.build();

		stage = new Stage();
		stage.addActor(cli);

		// Add an InputListener that will toggle the CLI's visibility on and off on the default ` key.
		stage.addListener(new LibGdxVisibilityToggler(cli));

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		stage.act();
		stage.draw();
	}
}
