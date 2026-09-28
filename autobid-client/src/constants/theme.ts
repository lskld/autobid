/**
 * Single source of truth for all app colors.
 * Light and dark mode variants are defined here.
 * These values are manually synced to global.css for Tailwind/NativeWind.
 */

import { Platform } from 'react-native';

// ============================================
// COLOR PALETTE - Source of Truth
// Update these, then copy to global.css
// ============================================
export const Colors = {
	light: {
		// Backgrounds
		bg: "#ffffff",
		surface: "#F0F0F3",
		background: "#ffffff",
		backgroundElement: "#F0F0F3",
		backgroundSelected: "#E0E1E6",

		// Text
		text: "#000000",
		textSecondary: "#60646C",
		primary: "#0E1319",
		secondary: "#60646C",

		// Accents
		accent: "#E8703A",
		"accent-2": "#D9A441",
		"accent-3": "#4E9B8F",

		// Semantic
		success: "#5FA860",
		error: "#D9544A",
		warning: "#E0A93E",
	},
	dark: {
		// Backgrounds
		bg: "#0E1319",
		surface: "#151C24",
		background: "#0E1319",
		backgroundElement: "#212225",
		backgroundSelected: "#2E3135",

		// Text
		text: "#ffffff",
		textSecondary: "#B0B4BA",
		primary: "#E8E4DC",
		secondary: "#8A94A0",

		// Accents (same as light - brand colors don't change)
		accent: "#E8703A",
		"accent-2": "#D9A441",
		"accent-3": "#4E9B8F",

		// Semantic (same as light - brand colors don't change)
		success: "#5FA860",
		error: "#D9544A",
		warning: "#E0A93E",
	},
} as const;

export type ThemeColor = keyof typeof Colors.light & keyof typeof Colors.dark;

// ============================================
// FONTS
// ============================================
/**
 * Geist is loaded in `src/app/_layout.tsx` via `useFonts`.
 * Each weight is registered as its own font family.
 */
export const Geist = {
  thin: 'Geist_100Thin',
  extraLight: 'Geist_200ExtraLight',
  light: 'Geist_300Light',
  regular: 'Geist_400Regular',
  medium: 'Geist_500Medium',
  semiBold: 'Geist_600SemiBold',
  bold: 'Geist_700Bold',
  extraBold: 'Geist_800ExtraBold',
  black: 'Geist_900Black',
} as const;

export const Fonts = Platform.select({
  ios: {
    sans: Geist.regular,
    serif: 'ui-serif',
    rounded: 'ui-rounded',
    mono: 'ui-monospace',
  },
  default: {
    sans: Geist.regular,
    serif: 'serif',
    rounded: 'normal',
    mono: 'monospace',
  },
  web: {
    sans: Geist.regular,
    serif: 'var(--font-serif)',
    rounded: 'var(--font-rounded)',
    mono: 'var(--font-mono)',
  },
});

// ============================================
// SPACING & LAYOUT
// ============================================
export const Spacing = {
  half: 2,
  one: 4,
  two: 8,
  three: 16,
  four: 24,
  five: 32,
  six: 64,
} as const;

export const BottomTabInset = Platform.select({ ios: 50, android: 80 }) ?? 0;
export const MaxContentWidth = 800;
