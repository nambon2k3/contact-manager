USE [HoLaFood]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 8/31/2023 3:13:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](45) NOT NULL,
	[email] [varchar](45) NOT NULL,
	[address] [varchar](100) NOT NULL,
	[phone] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Contact] ON 

INSERT [dbo].[Contact] ([id], [name], [email], [address], [phone]) VALUES (8, N'C&#7845;n Ng&#7885;c Huy&#7873;n', N'namadonis2003@gmail.com', N'Lai Thuong', N'0376626402')
INSERT [dbo].[Contact] ([id], [name], [email], [address], [phone]) VALUES (9, N'Nguy&#7877;n Vi&#7871;t Hoài Nam', N'namadonis2003@gmail.com', N'Kim Quan', N'0376626402')
INSERT [dbo].[Contact] ([id], [name], [email], [address], [phone]) VALUES (14, N'lkjlkj', N'lkjkljkl', N'kljkljkl', N'139')
SET IDENTITY_INSERT [dbo].[Contact] OFF
GO
