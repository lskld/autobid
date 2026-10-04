import { MD3DarkTheme } from "react-native-paper";
import { colors } from "./colors";

export const theme = {
  ...MD3DarkTheme,
  colors: {
    ...MD3DarkTheme.colors,
    primary: colors.accentPrimary,
    secondary: colors.accentSecondary,
    tertiary: colors.accentTertiary,
    background: colors.background,
    surface: colors.surface,
    error: colors.error,
  },
};

export type Theme = typeof theme;