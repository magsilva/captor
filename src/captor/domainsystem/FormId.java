/*
Copyright (C) 2007 Marco Aurélio Graciotto Silva <magsilva@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */


package captor.domainsystem;

import java.util.regex.Pattern;

public class FormId
{
	private String[] values;
	
	private boolean hasWildcard = false;
	
	private static String separatorPattern;

	public static final String separator = ".";
	
	public static final String wildcard = "*";

	
	public FormId(String id)
	{
		if (id == null || id.trim().isEmpty()) {
			throw new IllegalArgumentException("Not value was set in the identifier.");
		}
		
		separatorPattern = Pattern.quote(FormId.separator);
		values = id.split(separatorPattern);
		for (String str : values) {
			try {
				Integer.parseInt(str);
			} catch (NumberFormatException e) {
				if (values[values.length - 1].equals(str) && FormId.wildcard.equals(str)) {
					hasWildcard = true;
				} else {
					throw new IllegalArgumentException("Value " + id + " isn't a valid form identifier.");
				}
			}
		}
	}
	
	public String getPart(int i)
	{
		try {
			return values[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public int getCount()
	{
		return values.length;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (! (obj instanceof FormId)) {
			return false;
		}
		
		FormId id = (FormId) obj;
		if (getCount() != id.getCount()) {
			return false;
		}
		
		for (int i = 0; i < getCount(); i++) {
			if (! getPart(i).equals(id.getPart(i))) {
				if (i == (getCount() - 1)) {
					return (hasWildcard || id.hasWildcard);
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
