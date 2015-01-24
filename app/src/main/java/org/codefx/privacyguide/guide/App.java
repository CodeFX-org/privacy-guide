package org.codefx.privacyguide.guide;

import android.animation.AnimatorSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An app that the user can choose to install.
 */
public class App {

	private final String name;
	private final String packageName;
	private final String description;
	/** unmodifiable list of installers */
	private final List<Installer> installers;

	private App(Builder builder) {
		this.name = builder.name;
		this.packageName = builder.packageName;
		this.description = builder.description;
		this.installers = builder.installers;
	}

	public static Builder build(String name) {
		return new Builder(name);
	}

	public String getName() {
		return name;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getDescription() {
		return description;
	}

	/** @return the installers as an unmodifiable list */
	public List<Installer> getInstallers() {
		return installers;
	}

	@Override
	public String toString() {
		return name;
	}

	/*
	 * NESTED CLASSES
	 */

	public static class Builder {

		private String name;
		private String packageName;
		private String description;
		private List<Installer> installers;

		public Builder(String name) {
			this.name = name;
			installers = Collections.emptyList();
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder packageName(String packageName) {
			this.packageName = packageName;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		/**
		 * @param installers the array of installers is defensively copied
		 */
		public Builder installers(Installer... installers) {
			this.installers = Collections.unmodifiableList(Arrays.asList(installers));
			return this;
		}

		/**
		 * @param installers the list of installers is defensively copied
		 */
		public Builder installers(List<Installer> installers) {
			this.installers = Collections.unmodifiableList(new ArrayList<>(installers));
			return this;
		}

		public App build() {
			if (name == null || packageName == null || description == null)
				throw new IllegalStateException(
						"Name, package name and description must be set before an app can be built.");

			return new App(this);
		}

	}

}
