// Copyright 2013-2015 Michel Kraemer
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package de.undercouch.underline;

/**
 * This exception will be thrown if the {@link OptionParser} finds an
 * unknown option
 * @author Michel Kraemer
 */
public class InvalidOptionException extends OptionParserException {
	private static final long serialVersionUID = -6410586963277418040L;

	/**
	 * Constructs a new exception
	 * @param name the option
	 */
	public InvalidOptionException(String name) {
		super((name.startsWith("-") ? "invalid option" : "invalid command") +
				" `" + name + "'");
	}
}
