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
 * Abstract base class for exceptions thrown by the {@link OptionParser}
 * @author Michel Kraemer
 */
public abstract class OptionParserException extends Exception {
	private static final long serialVersionUID = -6233873410443975105L;
	
	/**
     * Constructs a new exception with the specified detail message
     * @param message the detail message
     * @see Exception#Exception(String)
     */
	public OptionParserException(String message) {
		super(message);
	}
}
